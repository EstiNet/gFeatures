package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Configuration.Config;

public class ConfigHub {
	Config config = new Config();
	public void setupConfig(){
		config.createDirectory("plugins/gFeatures/gWarsSuite", "gWarsSuite plugin directory set!");
	}
}
