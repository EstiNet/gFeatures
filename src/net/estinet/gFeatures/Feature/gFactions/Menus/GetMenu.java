package net.estinet.gFeatures.Feature.gFactions.Menus;

import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.estinet.gFeatures.Feature.gFactions.Blaze;
import net.genesishub.gFeatures.Basic;

public class GetMenu {
	public void start(PlayerInteractEntityEvent event){
		if(event.getRightClicked().getLocation().equals(Blaze.autorifle)){
			if(!Basic.getgPlayer(event.getPlayer().getUniqueId().toString()).getValue("gFactions.Tier").equals("autorifle")){
				
			}
		}
		else if(event.getRightClicked().getLocation().equals(Blaze.shotgun)){
			
		}
		else if(event.getRightClicked().getLocation().equals(Blaze.sniper)){
			
		}
	}
}
