package net.estinet.gFeatures.Feature.Grasslands;

import net.estinet.gFeatures.API.Minigame.Arena;
import net.estinet.gFeatures.API.Minigame.Game;
import net.estinet.gFeatures.API.Minigame.Resource;
import net.estinet.gFeatures.API.Minigame.Teams;
import net.estinet.gFeatures.Configuration.Config;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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

public class Enable{
	public static Teams hider = new Teams(ChatColor.DARK_AQUA + "Hider");
	public static Teams finder;
	public static Teams lobby;
	public static Arena currentarena;
	public static Game grasslands;
	public static Resource resource;
	public void onEnable(){
		Config config = new Config();
		config.createDirectory("plugins/gFeatures/Grasslands", "Created game directory!");
		config.createDirectory("plugins/gFeatures/Grasslands/maps", "Created game maps directory!");
		Bukkit.getLogger().info("Grasslands plugin enabled! Hi!");
		finder = new Teams(ChatColor.GOLD + "Finder");
		lobby = new Teams(ChatColor.GRAY + "Lobby");
		grasslands = new Game("Grasslands", 1);
		grasslands.addTeam(hider);
		grasslands.addTeam(finder);
		resource = new Resource();
		//resource.addMap(f, "Grasslands");
	}
}
