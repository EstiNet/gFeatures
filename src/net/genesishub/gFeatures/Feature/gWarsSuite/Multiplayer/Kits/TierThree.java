package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits;

import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.TierMenu;

import org.bukkit.entity.Player;

public class TierThree extends TierMenu{
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
