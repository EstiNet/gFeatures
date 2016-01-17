package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Mode;
import net.estinet.gFeatures.Feature.CTF.Team;
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
 							for(Player p : Bukkit.getOnlinePlayers()){
 								p.setLevel(0);
 								if(Basic.getOrangeSize() >= Basic.getBlueSize()){
 									Basic.teams.put(p.getUniqueId(), Team.BLUE);
 								}
 								else{
 									Basic.teams.put(p.getUniqueId(), Team.ORANGE);
 								}
 							}
 							for(UUID uuid : Basic.teams.keySet()){
 								if(Basic.teams.get(uuid).equals(Team.ORANGE)){
 									for(Player p : Bukkit.getServer().getOnlinePlayers()){
 										if(p.getUniqueId().equals(uuid)){
 											p.teleport(Basic.orangespawn);
 											p.setWalkSpeed((float) 0.3);
 										}
 									}
 								}
 								else{
 									for(Player p : Bukkit.getServer().getOnlinePlayers()){
 										if(p.getUniqueId().equals(uuid)){
 											p.teleport(Basic.bluespawn);
 											p.setWalkSpeed((float) 0.3);
 										}
 									}
 								}
 							}
 							
 							//Spawn flags
 						}
 						else{
 							Basic.countdown = 60;
 							Bukkit.getScheduler().cancelTask(tasknum);
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
