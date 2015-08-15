package net.genesishub.gFeatures.Feature.Grasslands;

import net.genesishub.gFeatures.Feature.Grasslands.Scoreboard.Countdown;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GameStart {
	Countdown cd = new Countdown();
	static int tasknum;
    int iter = 60;
		
	public void check(){
		if(Enable.lobby.getPlayers().size() >= 2){
			start();
		}
		else{
			Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "When there are 2 players on the server, the game will start!");
		}
	}
	public void start(){
		Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "The game will be starting in 1 minute.");
         		tasknum = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
         			public void run(){
         					if(iter == 0){
         						Bukkit.getScheduler().cancelTask(tasknum);
         						teleportPlayers();
         					}
	                  		for(Player p : Bukkit.getServer().getOnlinePlayers()){
	                  			p.setScoreboard(cd.get(p, iter));
	                  			p.setLevel(iter);
	                  			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 50, 50);
	                  		}
	                  		iter--;
	                    }
	        }, 0, 20L);
         for(int eggs = 100; eggs == 0; eggs--){
        	int randomx = (int) Math.floor(Math.random()*146);
        	int randomz = (int) Math.floor(Math.random()*43);
        	Location loc = new Location(Bukkit.getServer().getWorld("Grasslands"), randomx-20, 35, randomz);
        	loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.MONSTER_EGG));
         }
	}
	public void teleportPlayers(){
		
	}
	public void checkLeave(){
		if(Enable.lobby.getPlayers().size() >= 1){
			Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "Not enough players! The countdown will stop.");
			Bukkit.getScheduler().cancelTask(tasknum);
		}
	}
}
