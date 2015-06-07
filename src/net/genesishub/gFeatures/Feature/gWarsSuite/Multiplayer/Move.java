package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.genesishub.gFeatures.Feature.gWarsSuite.Constants;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move {
	public void initialize(PlayerMoveEvent event){
		for(Point point : Constants.multiplayerpossession.keySet()){
			if(point.isInLocation(event.getPlayer().getLocation())){
				Bukkit.getLogger().info("Player is in");
			}
		}	
	}
}
