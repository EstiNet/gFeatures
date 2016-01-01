package net.estinet.gFeatures.Feature.gFactions.Menus;

import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.estinet.gFeatures.Feature.gFactions.Blaze;

public class GetMenu {
	public void start(PlayerInteractEntityEvent event){
		if(event.getRightClicked().getLocation().equals(Blaze.autorifle)){
			
		}
		else if(event.getRightClicked().getLocation().equals(Blaze.shotgun)){
			
		}
		else if(event.getRightClicked().getLocation().equals(Blaze.sniper)){
			
		}
	}
}
