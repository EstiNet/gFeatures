package net.genesishub.gFeatures.Feature.Base;

import net.genesishub.gFeatures.Configuration.Config;

public class ConfigHub {
	Config config = new Config();
	public void setupConfig(){
		config.createDirectory("plugins/gFeatures/Test", "Base plugin directory set!");
		
	}
}
