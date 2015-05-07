package net.genesishub.gFeatures.Configuration;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.FeatureState;
import net.genesishub.gFeatures.gFeature;

public class LoadConfig {
	static Config config = new Config();
	static File f = new File("plugins/gFeatures/Config.yml");
	static List<gFeature> features = Basic.getFeatures();
	public static void load(){
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		for(gFeature feature : features){
			if((yamlFile.get("Config.Plugins." + feature.getName()).equals("true"))){
				feature.setState(FeatureState.ENABLE);
			}
			else{
				feature.setState(FeatureState.DISABLE);
			}
		}
	}
}
