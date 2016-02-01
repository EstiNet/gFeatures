package net.estinet.gFeatures.Feature.CTF;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Feature.CTF.Confligs.ConfligInit;
import net.estinet.gFeatures.Feature.CTF.MapsSpec.Spec;

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
	Spec spec = new Spec();
	ConfligInit ci = new ConfligInit();
	File f = new File("plugins/gFeatures/CTF/Config.yml");
	File ctf1 = new File("plugins/gFeatures/CTF/CTF1");
	File ctf2 = new File("plugins/gFeatures/CTF/CTF2");
	public void setupConfig(){
		List<Maps> maps = new ArrayList<>();
		config.createDirectory("plugins/gFeatures/CTF", "[CTF] plugin directory set!");
		if(ctf1.isDirectory()){
			maps.add(Maps.One);
		}
		if(ctf2.isDirectory()){
			maps.add(Maps.Two);
		}
		if(maps.isEmpty()){
			Bukkit.getLogger().info("[CTF] No maps found!");
			Disable.onDisable();
			net.estinet.gFeatures.Basic.getFeature("CTF").disable();
			return;
		}
		int random = (int) Math.floor(Math.random() * maps.size());
		spec.direction(maps.get(random));
		
		ci.createConfigs();
		/*if(!f.exists()){
			try{
			Bukkit.getLogger().info("[CTF] Setting up configs....");
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
			Bukkit.getLogger().info("[CTF] Successfully added config!");
			}
			catch(Exception e){
				
			}
		}*/
	}
}
