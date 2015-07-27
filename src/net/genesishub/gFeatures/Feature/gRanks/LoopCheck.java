package net.genesishub.gFeatures.Feature.gRanks;

import net.genesishub.gFeatures.Feature.gRanks.Perms.Cleanup;

import org.bukkit.Bukkit;

public class LoopCheck {
	public void start(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		Thread th = new Thread(new Runnable(){
        			public void run(){
        				Basis b = new Basis();
        				b.initializeQuery();
        			}
        		});
        		th.start();
        	}
        }, 1000L, 1000L);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		Thread th = new Thread(new Cleanup());
        		th.start();
        	}
        }, 9000L, 9000L);
	}
}
