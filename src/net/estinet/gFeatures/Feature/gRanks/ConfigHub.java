package net.estinet.gFeatures.Feature.gRanks;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import net.estinet.gFeatures.Configuration.Config;

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
	File f = new File("plugins/gFeatures/gRanks/Config.yml");
	public void setupConfig(){
		Config c = new Config();
		c.createDirectory("plugins/gFeatures/gRanks", "gRanks files created!");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		if(!f.exists()){
			Bukkit.getLogger().info("[gRanks] Setting up configs....");
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			yamlFile.createSection("Config");
			yamlFile.createSection("Config.MySQL");
			yamlFile.createSection("Config.MySQL.Address");
			yamlFile.createSection("Config.MySQL.Port");
			yamlFile.createSection("Config.MySQL.TableName");
			yamlFile.createSection("Config.MySQL.Username");
			yamlFile.createSection("Config.MySQL.Password");
			yamlFile.createSection("Config.ClioteSky");
			yamlFile.createSection("Config.ClioteSky.Enable");
			yamlFile.set("Config.MySQL.Port", "3306");
			yamlFile.set("Config.MySQL.Address", "localhost");
			yamlFile.set("Config.MySQL.TableName", "granks");
			yamlFile.set("Config.MySQL.Username", "root");
			yamlFile.set("Config.MySQL.Password", "pass123");
			yamlFile.set("Config.ClioteSky.Enable", "false");
			
			try {
				yamlFile.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Bukkit.getLogger().info("[gRanks] Successfully added config!");
		}
		Bukkit.getLogger().info("hi");
		if(!(yamlFile.contains("Config.ClioteSky.Enable"))){
			Bukkit.getLogger().info("hi");
			yamlFile.createSection("Config.ClioteSky");
			yamlFile.createSection("Config.ClioteSky.Enable");
			yamlFile.set("Config.ClioteSky.Enable", "false");
		}
	}
}
