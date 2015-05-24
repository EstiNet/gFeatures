package net.genesishub.gFeatures.Configuration;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Extension;
import net.genesishub.gFeatures.FeatureState;
import net.genesishub.gFeatures.gFeature;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class LoadConfig {
	static Config config = new Config();
	static File f = new File("plugins/gFeatures/Config.yml");
	static List<gFeature> features = Basic.getFeatures();
	static List<Extension> extensions = Basic.getExtensions();
	public static void load(){
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		for(gFeature feature : features){
			if((yamlFile.get("Config.Plugins." + feature.getName()).equals("true"))){
				feature.setState(FeatureState.ENABLE);
				Bukkit.getLogger().info(feature.getName());
			}
			else{
				feature.setState(FeatureState.DISABLE);
				Bukkit.getLogger().info(feature.getName());
			}
		}
		for(Extension extend : extensions){
			if((yamlFile.get("Config.Extensions."+ extend.getType().toString() + "." + extend.getName()).equals("true"))){
				extend.setState(FeatureState.ENABLE);
			}
			else{
				extend.setState(FeatureState.DISABLE);
			}
		}
	}
}
