package net.genesishub.gFeatures.Feature.Grasslands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GameStart {
	public void check(){
		if(Enable.lobby.getPlayers().size() >= 2){
			start();
		}
		else{
			Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "When there are 2 players on the server, the game will start!");
		}
	}
	public void start(){
		Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "The game will be starting in 30 seconds.");
		for(int iter = 30; iter != 0; iter--){
			final int doi = iter;
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	        	public void run(){
	        		for(Player p : Bukkit.getServer().getOnlinePlayers()){
	        			p.setExp(getExpLevel(doi));
	        		}
	        	}
	        }, 20L);
		}
	}
	public void checkLeave(){
		if(Enable.lobby.getPlayers().size() >= 1){
			Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "Not enough players! The game will be stopped.");
			GameStop gs = new GameStop();
			gs.stopGame();
		}
	}
	public int getExpLevel(int level) {
	    double whole = Math.floor(level);
	    double partial = level - whole;

	    double wholeXp = wholeLevelXp(whole);
	    double nextXp = wholeLevelXp(whole + 1) - wholeXp;
	    double partialXp = nextXp * partial;

	    return (int) (wholeXp + partialXp);
	}
	public double wholeLevelXp(double whole) {
	    double low = whole;
	    double mid = Math.max(0, whole - 15);
	    double high = Math.max(0, whole - 30);

	    return low * 17
	        + (mid * (mid - 1) / 2) * 3
	        + (high * (high - 1) / 2) * 7;
	}
}
