package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHub{
	public void onPlayerJoin(PlayerJoinEvent event){
		Bukkit.getLogger().info("Player Joined!");
	}
}
