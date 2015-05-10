package net.genesishub.gFeatures.Feature.GenesisAccess;

import net.genesishub.gFeatures.Configuration.Config;

public class ConfigHub {
	Config config = new Config();
	public void setupConfig(){
		config.createDirectory("plugins/gFeatures/GenesisAccess", "GenesisAccess plugin directory set!");
	}
}
