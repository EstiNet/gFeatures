package net.estinet.gFeatures.Feature.gRanksNew;

import net.estinet.gFeatures.Configuration.Config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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
	File f = new File("plugins/gFeatures/gRanks/config.yml");
	public void setupConfig(){
		Config c = new Config();
		c.createDirectory("plugins/gFeatures/gRanks", "gRanks files created!");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);

        HashMap<String, String> fields = new HashMap<>();

        fields.put("Config.MySQL.Address", "localhost");
        fields.put("Config.MySQL.Port", "3306");
        fields.put("Config.MySQL.TableName", "granks");
        fields.put("Config.MySQL.Username", "root");
        fields.put("Config.MySQL.Password", "pass123");
        fields.put("Config.ClioteSky.Enable", "false");

		if(!f.exists()){
			Bukkit.getLogger().info("[gRanks] Setting up configs....");
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Bukkit.getLogger().info("[gRanks] Successfully added config!");
		}

		if(!yamlFile.contains("Config")) yamlFile.createSection("Config");
		if(!yamlFile.contains("Config.MySQL")) yamlFile.createSection("Config.MySQL");
		if(!yamlFile.contains("Config.ClioteSky")) yamlFile.createSection("Config.ClioteSky");

        for(String key : fields.keySet()) {
		    if(!yamlFile.contains(key)) {
		        Bukkit.getLogger().info("[gRanks] Added config property: " + key);
		        yamlFile.createSection(key);
		        yamlFile.set(key, fields);
            }
        }
        try {
            yamlFile.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
