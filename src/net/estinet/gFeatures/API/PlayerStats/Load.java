package net.estinet.gFeatures.API.PlayerStats;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import net.estinet.gFeatures.Basic;
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

public class Load {
	File f = new File("plugins/gFeatures/Players");
	public void load(){
		Config config = new Config();
		config.createDirectory("plugins/gFeatures/Players", "Players directory created!");
		for(File file : f.listFiles()){
			YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(file);
			gPlayer gp = new gPlayer(yamlFile.get("Config.UUID").toString(), yamlFile.get("Config.Name").toString());
			for(String str :  yamlFile.getConfigurationSection("Config").getKeys(true)){
				gp.addValue(str, yamlFile.get("Config." + str).toString());
			}
			for(String str : Basic.getPlayerSections().keySet()){
				try{
					if(yamlFile.get("Config." + str).equals(null)){}
				}
				catch(Exception e){
					Bukkit.getLogger().info("Found a problem with the file! Attempting to patch " + str);
					yamlFile.createSection("Config." + str);
					yamlFile.set("Config." + str, Basic.getPlayerSections().get(str));
					gp.addValue(str, yamlFile.get("Config." + str).toString());
				}
			}
			try {
				yamlFile.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Basic.addgPlayer(gp);
		}
	}
}
