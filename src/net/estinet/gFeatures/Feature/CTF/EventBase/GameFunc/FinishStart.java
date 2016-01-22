package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Team;

public class FinishStart {
	public void finish(){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(Basic.teams.get(p.getUniqueId()).equals(Team.BLUE)){
				p.teleport(Basic.bluespawn);
			}
			else{
				p.teleport(Basic.orangespawn);
			}
		}
	}
}
