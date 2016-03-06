package net.estinet.gFeatures.Feature.GenesisEconomy;

import java.io.File;
import java.io.IOException;

import net.estinet.gFeatures.Configuration.Config;

import org.bukkit.Bukkit;
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

public class ConfigManager {
	File f = new File("plugins/gFeatures/gEconomy/Config.yml");
	public boolean check() throws IOException{
		Config c = new Config();
		c.createDirectory("plugins/gFeatures/gEconomy", "gEconomy files created!");
		if(!f.exists()){
			Bukkit.getLogger().info("[gEconomy] Setting up configs....");
			f.createNewFile();
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.MySQL");
			yamlFile.createSection("Config.MySQL.Address");
			yamlFile.createSection("Config.MySQL.Port");
			yamlFile.createSection("Config.MySQL.TableName");
			yamlFile.createSection("Config.MySQL.Username");
			yamlFile.createSection("Config.MySQL.Password");
			yamlFile.createSection("Config.Trade");
			yamlFile.createSection("Config.Trade.Rate");
			yamlFile.set("Config.MySQL.Port", "3306");
			yamlFile.set("Config.MySQL.Address", "localhost");
			yamlFile.set("Config.MySQL.TableName", "geconomy");
			yamlFile.set("Config.MySQL.Username", "root");
			yamlFile.set("Config.MySQL.Password", "pass123");
			yamlFile.set("Config.Trade.Rate", "100");
			yamlFile.save(f);
			Bukkit.getLogger().info("[gEconomy] Successfully added config!");
			return false;
		}
		return true;
	}
}
