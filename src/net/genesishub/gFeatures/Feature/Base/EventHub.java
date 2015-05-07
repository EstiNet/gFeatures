package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

import net.genesishub.gFeatures.Library;

public class EventHub extends Library{
	@Override
	public void onPlayerJoin(PlayerJoinEvent event){
		Bukkit.getLogger().info("Player Joined!");
	}
}
