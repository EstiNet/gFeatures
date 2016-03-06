package net.estinet.gFeatures.Feature.gWarsSuite;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Feature.gWarsSuite.Connection.Enabling;

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

public class ConfigHub {
	Config config = new Config();
	Configuration con = new Configuration(true);
	public void setupConfig(){
		File f = new File("plugins/gFeatures/gWarsSuite/Config.yml");
		boolean bool = !f.exists();
		config.createDirectory("plugins/gFeatures/gWarsSuite", "gWarsSuite plugin directory set!");
		config.createFile("plugins/gFeatures/gWarsSuite/Config.yml", "gWarsSuite plugin config set!");
		if(bool){
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		yamlFile.createSection("Config");
		yamlFile.createSection("Config.MySQL");
		yamlFile.createSection("Config.MySQL.Address");
		yamlFile.createSection("Config.MySQL.Port");
		yamlFile.createSection("Config.MySQL.TableName");
		yamlFile.createSection("Config.MySQL.Username");
		yamlFile.createSection("Config.MySQL.Password");
		yamlFile.set("Config.MySQL.Port", "3306");
		yamlFile.set("Config.MySQL.Address", "localhost");
		yamlFile.set("Config.MySQL.TableName", "gwars");
		yamlFile.set("Config.MySQL.Username", "root");
		yamlFile.set("Config.MySQL.Password", "pass123");
		try {
			yamlFile.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		Enabling en = new Enabling();
		en.start();
	}
	
}
