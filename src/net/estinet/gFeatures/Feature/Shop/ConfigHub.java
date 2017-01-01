package net.estinet.gFeatures.Feature.Shop;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import net.estinet.gFeatures.Configuration.Config;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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
	public void setupConfig(){
		config.createDirectory("plugins/gFeatures/Shop", "Shop plugin directory set!");
		config.createFile("plugins/gFeatures/Shop/Config.yml", "Shop plugin config set!");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(new File("plugins/gFeatures/Shop/Config.yml"));
		if(!(yamlFile.contains("Redis"))){
			yamlFile.createSection("Redis");
		}
		if(!(yamlFile.contains("Redis.IP"))){
			yamlFile.createSection("Redis.IP");
			yamlFile.set("Redis.IP", "localhost");
		}
		if(!(yamlFile.contains("Redis.Port"))){
			yamlFile.createSection("Redis.Port");
			yamlFile.set("Redis.Port", "6379");
		}
		if(!(yamlFile.contains("Redis.Password"))){
			yamlFile.createSection("Redis.Password");
			yamlFile.set("Redis.Password", "pass123");
		}
		if(!(yamlFile.contains("Redis.DatabaseNumber"))){
			yamlFile.createSection("Redis.DatabaseNumber");
			yamlFile.set("Redis.DatabaseNumber", "1");
		}
		Shop.IP = yamlFile.get("Redis.IP") + "";
		Shop.port = yamlFile.get("Redis.Port") + "";
		Shop.password = yamlFile.get("Redis.Password") + "";
		Shop.databaseNum = yamlFile.get("Redis.DatabaseNumber") + "";
		try {
			yamlFile.save(new File("plugins/gFeatures/Shop/Config.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
