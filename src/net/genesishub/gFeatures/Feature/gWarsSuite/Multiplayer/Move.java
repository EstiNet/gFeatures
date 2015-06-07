package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.genesishub.gFeatures.Feature.gWarsSuite.Constants;

import org.bukkit.event.player.PlayerMoveEvent;

public class Move {
	public void initialize(PlayerMoveEvent event){
		for(Point point : Constants.multiplayerpossession.keySet()){
			if(point.isInLocation(event.getPlayer().getLocation())){
				//TODO Make the thing
			}
		}	
	}
}
