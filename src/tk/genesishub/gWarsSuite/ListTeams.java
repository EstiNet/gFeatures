package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class ListTeams{
	Constants cons = new Constants();
	StatsRetrieve sr = new StatsRetrieve();
	public void TeamListInitiate(final CommandSender sender, Command cmd, String label, String[] args){
	doorange((Player)sender);
	BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gWarsSuite"), new Runnable() {
    	public void run(){
       doblue((Player)sender);
       }
    }, 6L);
    }
	public void doorange(Player sender){
		try{
		orangelist((Player) sender);
		}
		catch(Exception e){
			Bukkit.getServer().getLogger().info("UHOH");
		}
	}
	public void doblue(Player sender){
		try{
		bluelist((Player) sender);
		}
		catch(Exception e){
			Bukkit.getServer().getLogger().info("UHOH");
		}
	}
	public void orangelist(Player sender){
		sender.sendMessage(ChatColor.GOLD+"Orange Team Members:");
		sender.sendMessage("There are " + Constants.ot.size() + " players on this team.");
		for(int iter = 0; iter <= Constants.ot.size(); iter++){
			sender.sendMessage(Constants.ot.get(iter) + " with " + sr.getKills(Constants.ot.get(iter)) + " kills");
		}
		return;
	}
	public void bluelist(Player sender){
		sender.sendMessage(ChatColor.DARK_AQUA+"Blue Team Members:");
		sender.sendMessage("There are " + Constants.bt.size() + " players on this team.");
		for(int iter = 0; iter <= Constants.bt.size(); iter++){
			sender.sendMessage(Constants.bt.get(iter) + " with " + sr.getKills(Constants.bt.get(iter)) + " kills");
		}
		return;
	}	
}
