package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.genesishub.gFeatures.Feature.gWarsSuite.Constants;
import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;
import net.genesishub.gFeatures.Feature.gWarsSuite.gWarsMode;

public class Finish {
	Statistics stats = new Statistics();
	Join join = new Join();
	public void intialize(Player p){
		stats.setMode(p, gWarsMode.TEAM);
		join.end(p);
		p.teleport(new Location(Bukkit.getServer().getWorld("gWars"), Constants.spawndump.get(p.getName()).getX(), Constants.spawndump.get(p.getName()).getY(), Constants.spawndump.get(p.getName()).getZ()));
		Constants.spawndump.remove(p);
	}
}
