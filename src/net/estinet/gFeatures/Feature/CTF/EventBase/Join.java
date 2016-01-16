package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.PlayerMode;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.StartStop;

public class Join {
	StartStop ss = new StartStop();
	Spectate s = new Spectate();
	public void init(PlayerJoinEvent event){
		switch(Basic.mode){
		case WAITING:
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.WAITING);
			if(Bukkit.getOnlinePlayers().size() >= 2){
				Action.sendAll(ChatColor.AQUA + "Enough players! Game will be starting in 1 minute.");
				ss.start();
			}
			break;
		case ENDED:
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.SPECTATE);
			s.handler(event.getPlayer());
			break;
		case STARTED:
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.SPECTATE);
			break;
		default:
			break;
		}
	}
}
