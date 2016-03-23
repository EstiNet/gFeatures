package net.estinet.gFeatures.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Extension;
import net.estinet.gFeatures.ExtensionsType;
import net.estinet.gFeatures.gFeature;

import org.bukkit.configuration.file.YamlConfiguration;

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
		if(!(yamlFile.contains("Config.MySQL"))){
			yamlFile.createSection("Config.MySQL");
			yamlFile.createSection("Config.MySQL.Address");
			yamlFile.createSection("Config.MySQL.Port");
			yamlFile.createSection("Config.MySQL.TableName");
			yamlFile.createSection("Config.MySQL.Username");
			yamlFile.createSection("Config.MySQL.Password");
			yamlFile.createSection("Config.MySQL.State");
			yamlFile.set("Config.MySQL.Port", "3306");
			yamlFile.set("Config.MySQL.Address", "localhost");
			yamlFile.set("Config.MySQL.TableName", "gfeatures");
			yamlFile.set("Config.MySQL.Username", "root");
			yamlFile.set("Config.MySQL.Password", "pass123");
			yamlFile.set("Config.MySQL.State", "false");
		}
		if(!(yamlFile.contains("Config.ClioteSky"))){
			yamlFile.createSection("Config.ClioteSky.Address");
			yamlFile.createSection("Config.ClioteSky.Port");
			yamlFile.createSection("Config.ClioteSky.Category");
			yamlFile.createSection("Config.ClioteSky.Name");
			yamlFile.createSection("Config.ClioteSky.Password");
			yamlFile.createSection("Config.ClioteSky.Enable");
			yamlFile.set("Config.ClioteSky.Address", "localhost");
			yamlFile.set("Config.ClioteSky.Port", "36000");
			yamlFile.set("Config.ClioteSky.Category", "Default");
			yamlFile.set("Config.ClioteSky.Name", "Server");
			yamlFile.set("Config.ClioteSky.Password", "password");
			yamlFile.set("Config.ClioteSky.Enable", "false");
		}
		try {
			yamlFile.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
