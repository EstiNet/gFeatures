package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Spectate {
	public void handler(Player p){
		p.setGameMode(GameMode.SPECTATOR);
	}
}
