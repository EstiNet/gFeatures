package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.API.PlayerStats.gPlayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventHub {
	public void onPlayerJoin(PlayerJoinEvent event){
		Bukkit.getLogger().info("Player Joined!");
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		Player p = event.getPlayer();
		//MAKE SURE YOU RESET MODE
	}
}
