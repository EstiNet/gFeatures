package net.genesishub.gFeatures.Configuration;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.gFeature;

public class LoadConfig {
	static Config config = new Config();
	static File f = new File("plugins/gFeatures/Config.yml");
	static MainConfig configuration = Basic.getConfig();
	static List<gFeature> features = configuration.getFeatures();
	public static void load(){
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		 
	}
}
