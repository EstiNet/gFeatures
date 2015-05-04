package net.genesishub.gFeatures.Feature.gFactions;

import org.bukkit.event.player.PlayerJoinEvent;

public class JoinManager {
	Camera c = new Camera();
	public void Initialize(PlayerJoinEvent event){
		if(!event.getPlayer().hasPlayedBefore()){
			c.Tutorial(event.getPlayer());
		}
	}
}
