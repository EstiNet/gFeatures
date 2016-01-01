package net.estinet.gFeatures.Feature.gFactions;

import org.bukkit.entity.EnderCrystal;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.world.WorldLoadEvent;

public class EventHub {
	public void onPlayerInteract(PlayerInteractEntityEvent event){
		if(event.getRightClicked().getEntityId() == 426){
			event.setCancelled(true);
		}
	}
	public void onWorldLoad(WorldLoadEvent event){
		if(event.getWorld().getName().equals("Factions1.8.3")){
		Blaze.world.spawn(Blaze.sniper, EnderCrystal.class);
		Blaze.world.spawn(Blaze.shotgun, EnderCrystal.class);
		Blaze.world.spawn(Blaze.autorifle, EnderCrystal.class);
		}
	}
}
