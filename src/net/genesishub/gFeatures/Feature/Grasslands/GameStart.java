package net.genesishub.gFeatures.Feature.Grasslands;

import net.genesishub.gFeatures.Feature.Grasslands.Scoreboard.Countdown;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GameStart {
	Countdown cd = new Countdown();
	Thread thr = new Thread(new Runnable(){
		public void run(){
		for(int iter = 30; iter != -1; iter--){
			for(Player p : Bukkit.getServer().getOnlinePlayers()){
				p.setScoreboard(cd.get(p, iter));
	        	p.setLevel(iter);
	        	p.playSound(p.getLocation(), Sound.NOTE_PIANO, 50, 50);
	        }
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
		});
	public void check(){
		if(Enable.lobby.getPlayers().size() >= 2){
			start();
		}
		else{
			Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "When there are 2 players on the server, the game will start!");
		}
	}
	public void start(){
		Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "The game will be starting in 1 minute and 30 seconds.");
		thr.start();
	}
	public void checkLeave(){
		if(Enable.lobby.getPlayers().size() >= 1){
			Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "Not enough players! The countdown will stop.");
			thr.interrupt();
			GameStop gs = new GameStop();
			gs.stopGame();
		}
	}
}
