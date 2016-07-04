package net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.Feature.Gliders.Basic;

public class Swap {
	public void init(){
		Basic.swap = true;
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				if(!Basic.swap){
					Swap swap = new Swap();
					swap.init();
				}
			}
		}, 6000L);// counter just in case game keeps going
	}
}
