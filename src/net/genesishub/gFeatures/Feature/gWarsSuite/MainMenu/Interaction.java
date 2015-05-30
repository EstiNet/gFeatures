package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;
import net.genesishub.gFeatures.Feature.gWarsSuite.gWarsMode;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interaction {
	Statistics stats = new Statistics();
	public void intialize(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(stats.getMode(p).equals(gWarsMode.MAINMENU)){
			
		}
	}
}
