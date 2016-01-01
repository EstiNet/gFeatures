package net.estinet.gFeatures.Feature.gFactions;

import org.bukkit.Bukkit;
import org.bukkit.entity.EnderCrystal;

public class Enable {
	public void plzenable(){
		Bukkit.getLogger().info("gFactions initialized! Yay!");
		Blaze.world.spawn(Blaze.sniper, EnderCrystal.class);
		Blaze.world.spawn(Blaze.shotgun, EnderCrystal.class);
		Blaze.world.spawn(Blaze.autorifle, EnderCrystal.class);
	}
}
