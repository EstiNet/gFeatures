package net.genesishub.gFeatures.Configuration;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class SetupConfig {
	Config config = new Config();
	File f = new File("plugins/gFeatures/Config.yml");
	public void setup(){
		config.createFile("plugins/gFeatures/Config.yml", "Setup the gFeatures config for use!");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
	}
}
