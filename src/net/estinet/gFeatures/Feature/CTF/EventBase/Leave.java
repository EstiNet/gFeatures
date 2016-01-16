package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Feature.CTF.Basic;

public class Leave {
	public void init(PlayerQuitEvent event){
		Basic.modes.remove(event.getPlayer().getUniqueId());
	}
}
