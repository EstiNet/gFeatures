package net.genesishub.gFeatures.Feature.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventHub {
	public void onPlayerJoin(PlayerJoinEvent event){
		Bukkit.getLogger().info("Player Joined!");
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		
	}
}
