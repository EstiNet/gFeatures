package net.genesishub.gFeaturesSponge.API.PlayerStats;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.genesishub.gFeaturesSponge.Basic;
import net.genesishub.gFeaturesSponge.Configuration.Config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

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

public class ConfigHub {
	static Config config = new Config();
	static File f = new File("plugins/gFeatures/Players/players.yml");
	static HashMap<String, String> playersections = Basic.getPlayerSections();
	public void setupConfig(){
		Config config = new Config();
		config.createDirectory("plugins/gFeatures/Players", "Setup the players directory for use!");
		config.createFile("plugins/gFeatures/Players/players.yml", "Setup the players file for use!");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		if(!(yamlFile.contains("Players"))){
		yamlFile.createSection("Players");
		}
		try {
			yamlFile.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadConfig(){
		List<gPlayer> players = new ArrayList<>();
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		List<String> player = yamlFile.getStringList("Players");
		for(String play : player){
			players.add(new gPlayer(yamlFile.getName(), yamlFile.getString("Players." + play + ".Name." + play)));
		}
		Basic.setgPlayers(players);
		try {
			yamlFile.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addPlayerSection(Player p){
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		if(!(yamlFile.contains("Players." + p.getUniqueId()))){
			yamlFile.createSection("Players." + p.getUniqueId());
		}
		if(!(yamlFile.contains("Players." + p.getUniqueId() + ".Name." + p.getName()))){
			yamlFile.createSection("Players." + p.getUniqueId() + ".Name." + p.getName());
		}
		for(String value : playersections.keySet()){
			if(!(yamlFile.contains("Players." + p.getUniqueId() + "." + value))){
				yamlFile.createSection("Players." + p.getUniqueId() + "." + value);
				yamlFile.set("Players." + p.getUniqueId() + "." + value, playersections.get(value));
			}
		}
		try{
		gPlayer player = Basic.getgPlayer(p.getName());
		Basic.removegPlayer(player);
		player.setPlayer(p);
		Basic.addgPlayer(player);
		} catch (Exception e){
			Basic.addgPlayer(new gPlayer(p));
		}
		
		try {
			yamlFile.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
