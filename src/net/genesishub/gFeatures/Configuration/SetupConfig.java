package net.genesishub.gFeatures.Configuration;

import java.io.File;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Features;

import org.bukkit.configuration.file.YamlConfiguration;

public class SetupConfig {
	Config config = new Config();
	File f = new File("plugins/gFeatures/Config.yml");
	MainConfig configuration = Basic.getConfig();
	List<gFeature> features = configuration.getFeatures();
	public void setup(){
		config.createFile("plugins/gFeatures/Config.yml", "Setup the gFeatures config for use!");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		if(!(yamlFile.contains("Config"))){
		yamlFile.createSection("Config");
		}
		if(!(yamlFile.contains("Config.Plugins"))){
		yamlFile.createSection("Config.Plugins");
		}
		for(configuration.getFeatures() : gFeature feature){
			
		}
	}
}
