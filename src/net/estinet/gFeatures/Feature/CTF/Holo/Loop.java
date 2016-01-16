package net.estinet.gFeatures.Feature.CTF.Holo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Loop {
	CTFScore ctfs = new CTFScore();
	public void goThrough(){
		for(Player p : Bukkit.getServer().getOnlinePlayers()){
			ctfs.Initialize(p);
		}
	}
}
