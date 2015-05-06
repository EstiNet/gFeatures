package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.Bukkit;

import net.genesishub.gFeatures.Disabler;

public class Disable extends Disabler{
	@Override
	public void onDisable(){
		Bukkit.getLogger().info("Base Plugin Disabled!");
	}
}
