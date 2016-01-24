package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Team;
import net.estinet.gFeatures.Feature.CTF.Holo.CTFScore;

public class FinishStart {
	public void finish(){
		CTFScore ctfs = new CTFScore();
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setScoreboard(ctfs.Initialize(p));
			if(Basic.teams.get(p.getUniqueId()).equals(Team.BLUE)){
				p.teleport(Basic.bluespawn);
			}
			else{
				p.teleport(Basic.orangespawn);
			}
		}
	}
}
