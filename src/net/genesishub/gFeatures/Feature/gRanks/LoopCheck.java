package net.genesishub.gFeatures.Feature.gRanks;

import org.bukkit.Bukkit;

public class LoopCheck {
	public void start(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		Basis b = new Basis();
        		b.initializeQuery();
        	}
        }, 1000L, 1000L);
	}
}
