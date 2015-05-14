package net.genesishub.gFeatures.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Extension;
import net.genesishub.gFeatures.ExtensionsType;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.configuration.file.YamlConfiguration;

public class SetupConfig {
	static Config config = new Config();
	static File f = new File("plugins/gFeatures/Config.yml");
	static List<gFeature> features = Basic.getFeatures();
	static List<Extension> extensions = Basic.getExtensions();
	public static void setup(){
		config.createDirectory("plugins/gFeatures", "Setup the gFeatures directory for use!");
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
				yamlFile.set("Config.Plugins." + feature.getName() , "false");
			}
		}
		if(!(yamlFile.contains("Config.Extensions"))){
			yamlFile.createSection("Config.Extensions");
		}
		for(ExtensionsType type : ExtensionsType.values()){
			if(!(yamlFile.contains("Config.Extensions." + type.toString()))){
				yamlFile.createSection("Config.Extensions." + type.toString());
			}
		}
		for(Extension extend : extensions){
			if(!(yamlFile.contains("Config.Extensions." + extend.getType().toString() + "." + extend.getName()))){
				yamlFile.createSection("Config.Extensions." + extend.getType().toString() + "." + extend.getName());
				yamlFile.set("Config.Extensions." + extend.getType().toString() + "." + extend.getName() , "false");
			}
		}
		try {
			yamlFile.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
