package net.estinet.gFeatures.Feature.gFactions;

import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EventHub {
	public void onPlayerInteract(PlayerInteractEntityEvent event){
		if(event.getRightClicked().getEntityId() == 426){
			event.setCancelled(true);
		}
	}
}
