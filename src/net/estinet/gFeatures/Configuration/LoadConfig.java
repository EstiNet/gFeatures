package net.estinet.gFeatures.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Extension;
import net.estinet.gFeatures.FeatureState;
import net.estinet.gFeatures.gFeature;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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
		List<gFeature> featur = new ArrayList<>();
		List<Extension> extension = new ArrayList<>();
		for(gFeature feature : features){
			if((yamlFile.get("Config.Plugins." + feature.getName()).equals("true"))){
				feature.setState(FeatureState.ENABLE);
			}
			else{
				feature.setState(FeatureState.DISABLE);
			}
			featur.add(feature);
		}
		for(Extension extend : extensions){
			if((yamlFile.get("Config.Extensions."+ extend.getType().toString() + "." + extend.getName()).equals("true"))){
				extend.setState(FeatureState.ENABLE);
			}
			else{
				extend.setState(FeatureState.DISABLE);
			}
			extension.add(extend);
		}
		Basic.setFeatures(featur);
		Basic.setExtensions(extension);
	}
}
