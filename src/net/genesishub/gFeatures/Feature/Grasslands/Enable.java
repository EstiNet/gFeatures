package net.genesishub.gFeatures.Feature.Grasslands;

import net.genesishub.gFeatures.API.Minigame.Arena;
import net.genesishub.gFeatures.API.Minigame.Game;
import net.genesishub.gFeatures.API.Minigame.Resource;
import net.genesishub.gFeatures.API.Minigame.Teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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

public class Enable{
	static Teams hider;
	static Teams finder;
	static Teams lobby;
	static Arena currentarena;
	static Game grasslands;
	static Resource resource;
	public void onEnable(){
		Bukkit.getLogger().info("Grasslands plugin enabled! Hi!");
		hider = new Teams(ChatColor.DARK_AQUA + "Hider");
		finder = new Teams(ChatColor.GOLD + "Finder");
		finder = new Teams(ChatColor.GRAY + "Lobby");
		grasslands = new Game("Grasslands", 1);
		grasslands.addTeam(hider);
		grasslands.addTeam(finder);
		resource = new Resource();
		resource.addMap(f, name, "Grasslands");
	}
}
