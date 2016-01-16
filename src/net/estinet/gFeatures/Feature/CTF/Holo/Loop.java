package net.estinet.gFeatures.Feature.CTF.Holo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Mode;

public class Loop {
	CTFScore ctfs = new CTFScore();
	Lobby lobby = new Lobby();
	public void goThrough(){
		for(Player p : Bukkit.getServer().getOnlinePlayers()){
			if(Basic.mode.equals(Mode.STARTED) || Basic.mode.equals(Mode.ENDED)){
				ctfs.Initialize(p);
			}
			else if(Basic.mode.equals(Mode.WAITING)){
				
			}
		}
	}
}
