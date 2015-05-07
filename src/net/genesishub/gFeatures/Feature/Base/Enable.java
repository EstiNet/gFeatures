package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.Bukkit;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Enabler;
import net.genesishub.gFeatures.FeatureState;

public class Enable extends Enabler{
	@Override
	public void onEnable(){
		if(Basic.getFeature("Base").getState().equals(FeatureState.ENABLE)){
		Bukkit.getLogger().info("Base Plugin enabled!");
		}
		else{
			Bukkit.getLogger().info("Test");
		}
	}
}
