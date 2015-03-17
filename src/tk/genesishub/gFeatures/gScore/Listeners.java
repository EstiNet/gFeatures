package tk.genesishub.gFeatures.gScore;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import com.earth2me.essentials.api.UserDoesNotExistException;

public class Listeners {
	final Scored s = new Scored();
	public void onEnable(){
		Bukkit.getLogger().info("gScore is enabled! Stuff will happen!");
	}
	public void onDisable(){
		Bukkit.getLogger().info("gScore is disabled! :(");
	}
	public void onPlayerJoin(final PlayerJoinEvent event) throws IllegalArgumentException, IllegalStateException, UserDoesNotExistException{
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		try {
					event.getPlayer().setScoreboard(s.Initialize(event.getPlayer()));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserDoesNotExistException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           }
        }, 100L);
		Bukkit.getLogger().info("Scoreboard initiated.");
	}
}
