package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class StartStop {
	static int tasknum;
    int iter = 60;
	public void start(){
		tasknum = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
 			public void run(){
 					if(iter <= 0){
 						Bukkit.getScheduler().cancelTask(tasknum);
 						teleportPlayers();
 					}
 					else{
              		for(Player p : Bukkit.getServer().getOnlinePlayers()){
              			p.setScoreboard(cd.get(p, iter));
              			p.setLevel(iter);
              			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 50, 50);
              		}
              		}
              		iter--;
                }
    }, 0, 20L);
	}
	public void stop(){
		
	}
}
