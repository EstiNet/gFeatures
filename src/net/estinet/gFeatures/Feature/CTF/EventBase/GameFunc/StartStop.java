package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Holo.Loop;

public class StartStop {
	static int tasknum;
	Loop loop = new Loop();
	public void start(){
		tasknum = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
 			public void run(){
 					if(Basic.countdown <= 0){
 						if(Bukkit.getServer().getOnlinePlayers().size() >= 2){
 							Bukkit.getScheduler().cancelTask(tasknum);
 							Basic.mode = Mode.STARTED;
 							teleportPlayers();
 						}
 					}
 					else{
 					loop.goThrough();
              		for(Player p : Bukkit.getServer().getOnlinePlayers()){
              			p.setLevel(Basic.countdown);
              			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 50, 50);
              		}
              		}
              		Basic.countdown--;
                }
    }, 0, 20L);
	}
	public void stop(){
		
	}
}
