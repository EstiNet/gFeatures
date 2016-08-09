package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Misc.ParticleEffect;

public class TrailLoop {
	public void init(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		for(Player p : Bukkit.getOnlinePlayers()){
        			switch(Shop.playerTrail.get(p.getUniqueId())){
        			case "NONE":
        				continue;
        			case "FIRE":
        				ParticleEffect.FLAME.display(0, 0, 0, 3, 1, p.getLocation(), 100);
        				break;
        			}
        		}
        	}
        }, 5L, 5L);
	}
}
