package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits;

import org.bukkit.entity.Player;

public class TierOne extends TierMenu{
	public void initialize(String value, Player p){
		switch(value){
		case "AUTORIFLE":
			autorifle(p);
			break;
		case "SHOTGUN":
			shotgun(p);
			break;
		case "SNIPER":
			sniper(p);
			break;
		case "SPECIAL": 
			special(p);
			break;
		}
	}
	public void autorifle(Player p){
		
	}
	public void shotgun(Player p){
		
	}
	public void sniper(Player p){
		
	}
	public void special(Player p){
		
	}
}
