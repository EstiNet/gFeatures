package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;

public class TrailLoop {
	public void init(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		for(Player p : Bukkit.getOnlinePlayers()){
        			switch(Shop.playerTrail.get(p.getUniqueId())){
        			case "NONE":
        				continue;
        			case "FIRE":
        				//ParticleEffect.FLAME.display(0, 0, 0, 3, 1, p.getLocation(), 100);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.FLAME, 34);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.FLAME, 28);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.LAVA_POP, 31);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.LAVADRIP, 32);
        				break;
        			case "WATER":
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 34);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 28);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31, 21);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31, 15);
        				break;
        			case "GRAY":
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.CLOUD, 34);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 28, 7);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 31, 7);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 31, 21);
        				Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 31, 15);
        				break;
        			}
        		}
        	}
        }, 5L, 5L);
	}
}
