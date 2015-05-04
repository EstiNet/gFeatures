package net.genesishub.gFeatures.Configuration;

public class SetupConfig {
	Config config = new Config();
	public void setup(){
		config.createFile("plugins/gFeatures/Config.yml", "Setup the gFeatures config for use!");
	}
}
