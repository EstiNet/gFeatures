package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class GunMenu {
	public void setup(Player p){
		TierMenu tm = new TierMenu(p);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		tm.setup(p);
        	}
        }, 20L);
        
	}
	public void interaction(PlayerInteractEvent event){
		TierMenu tm = new TierMenu(event.getPlayer());
		tm.interact(event);
	}
}
