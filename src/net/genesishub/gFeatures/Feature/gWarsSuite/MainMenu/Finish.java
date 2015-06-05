package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import org.bukkit.entity.Player;

import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;
import net.genesishub.gFeatures.Feature.gWarsSuite.gWarsMode;

public class Finish {
	Statistics stats = new Statistics();
	Join join = new Join();
	public void intialize(Player p){
		stats.setMode(p, gWarsMode.TEAM);
		join.end(p);
	}
}
