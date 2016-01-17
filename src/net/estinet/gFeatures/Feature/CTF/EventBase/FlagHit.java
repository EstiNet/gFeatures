package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Team;

public class FlagHit {
	public void init(Location loc, Player p){
		if(loc.getBlockX() == Basic.blueflag.getBlockX() && loc.getBlockY() == Basic.blueflag.getBlockY() && loc.getBlockX() == Basic.blueflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE)){
			//Captured the blue flag
		}
		else if(loc.getBlockX() == Basic.orangeflag.getBlockX() && loc.getBlockY() == Basic.orangeflag.getBlockY() && loc.getBlockX() == Basic.orangeflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.BLUE)){
			//Captured the orange flag
		}
	}
}
