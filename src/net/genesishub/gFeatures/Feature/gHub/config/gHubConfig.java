package net.genesishub.gFeatures.Feature.gHub.config;

import net.genesishub.gFeatures.Configuration.Config;

public class gHubConfig {
	public void setup(){
		Config c = new Config();
		c.createDirectory("plugins/gFeatures/gHub", "Created gHub directory!");
		c.createFile("plugins/gFeatures/gHub/Config.yml", "Created gHub config!");
	}
	public void retrieve(){
		
	}
}
