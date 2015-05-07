package net.genesishub.gFeatures.Configuration;

import java.io.File;
import java.util.List;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.configuration.file.YamlConfiguration;

public class SetupConfig {
	static Config config = new Config();
	static File f = new File("plugins/gFeatures/Config.yml");
	static List<gFeature> features = Basic.getFeatures();
	public static void setup(){
		config.createFile("plugins/gFeatures/Config.yml", "Setup the gFeatures config for use!");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		if(!(yamlFile.contains("Config"))){
		yamlFile.createSection("Config");
		}
		if(!(yamlFile.contains("Config.Plugins"))){
		yamlFile.createSection("Config.Plugins");
		}
		for(gFeature feature : features){
			if(!(yamlFile.contains("Config.Plugins." + feature.getName()))){
				yamlFile.createSection("Config.Plugins." + feature.getName());
			}
		}
		if(!(yamlFile.contains("Config.Plus"))){
			yamlFile.createSection("Config.Plus");
		}
		if(!(yamlFile.contains("Config.Plus.Skript"))){
			yamlFile.createSection("Config.Plus.Skript");
		}
	}
}
