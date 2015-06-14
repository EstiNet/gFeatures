package net.genesishub.gFeatures.Feature.gHub;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHub {
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
	}
	public void onPlayerDrop(PlayerDropItemEvent event){
		
	}
}
