package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Dead {
	public void init(Player p){
		p.setGameMode(GameMode.SPECTATOR);
	}
}
