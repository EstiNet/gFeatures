package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.Bukkit;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Disabler;
import net.genesishub.gFeatures.FeatureState;

public class Disable extends Disabler{
	@Override
	public void onDisable(){
		if(Basic.getFeature("Base").getState().equals(FeatureState.ENABLE)){
		Bukkit.getLogger().info("Base Plugin Disabled!");
		}
	}
}
