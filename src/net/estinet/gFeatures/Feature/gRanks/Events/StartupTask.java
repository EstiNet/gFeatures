package net.estinet.gFeatures.Feature.gRanks.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.PermissionAttachment;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Retrieve;
import net.estinet.gFeatures.Feature.gRanks.SQLConnect;

public class StartupTask {
	public void init(PlayerJoinEvent event){
		SQLConnect sqlc = new SQLConnect();
		Retrieve r = new Retrieve();
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				Player p = event.getPlayer();
				sqlc.Connect(sqlc.toURL(r.getPort(), r.getAddress(), r.getTablename()), r.getUsername(), r.getPassword(), "INSERT INTO People(UUID, Rank)\n"+
						"SELECT * FROM (SELECT '" + event.getPlayer().getUniqueId().toString() + "', 'Default') AS tmp\n"+
						"WHERE NOT EXISTS (\n"+
						"SELECT UUID FROM People WHERE UUID = '" + event.getPlayer().getUniqueId().toString() + "'\n"+
						") LIMIT 1;\n"
						);
				if(!Basis.hasRank(p)){
					r.setRank(Basis.getRank("Default"), p);
				}
			}
		}, 40L);
		try{
		PermissionAttachment pa = event.getPlayer().addAttachment(Bukkit.getPluginManager().getPlugin("gFeatures"));
		for(String perm : Basis.getRank(r.getRank(event.getPlayer())).getPerms()){
			if(perm.equals("'*'")){
				event.getPlayer().setOp(true);
			}
			else{
				boolean isittrue;
				if(perm.contains("-")){
					isittrue = false;
					perm = perm.replace("-", "");
				}
				else{
					isittrue = true;
				}
				Debug.print("[gRanks] Set permission " + perm + " to " + isittrue + " for player " + event.getPlayer().getName());
				pa.setPermission(perm, isittrue);
			}
		}
		if(!Basis.getRank(r.getRank(event.getPlayer())).getPerms().contains("'*'")){
			event.getPlayer().setOp(false);
		}
		Basis.addPermissionAttach(event.getPlayer().getUniqueId(), pa);
		}
		catch(NullPointerException e){
			Thread thr = new Thread(new Runnable(){
				public void run(){
					StartupTask st = new StartupTask();
					st.init(event);
				}
			});
			thr.start();
		}
	}
}
