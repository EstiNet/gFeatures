package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.Bukkit;

import net.genesishub.gFeatures.Enabler;

public class Enable extends Enabler{
	@Override
	public void onEnable(){
		Bukkit.getLogger().info("Base Plugin enabled!");
	}
}
