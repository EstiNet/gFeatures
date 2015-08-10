package net.genesishub.gFeatures.Feature.gRanks;

import net.genesishub.gFeatures.API.Logger.Debug;
import net.genesishub.gFeatures.Feature.gRanks.Perms.Cleanup;

import org.bukkit.Bukkit;

public class LoopCheck {
	public void start(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		Thread th = new Thread(new Runnable(){
        			public void run(){
        				try{
        				Basis b = new Basis();
        				b.initializeQuery();
        				}
        				catch(Exception e){
        					Debug d = new Debug();
        					d.print(e.getMessage());
        				}
        			}
        		});
        		th.start();
        	}
        }, 1000L, 1000L);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		try{
        		Thread th = new Thread(new Cleanup());
        		th.start();
        		}
        		catch(Exception e){
        			Debug d = new Debug();
					d.print(e.getMessage());
        		}
        	}
        }, 9000L, 9000L);
	}
}
