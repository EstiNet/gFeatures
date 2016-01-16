package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.PlayerMode;

public class Join {
	public void init(PlayerJoinEvent event){
		switch(Basic.mode){
		case WAITING:
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.WAITING);
			break;
		case ENDED:
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.SPECTATE);
			break;
		case STARTED:
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.SPECTATE);
			break;
		default:
			break;
		}
	}
}
