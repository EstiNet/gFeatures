package net.genesishub.gFeatures.Feature.CTF;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.genesishub.gFeatures.API.Minigame.Arena;
import net.genesishub.gFeatures.API.Minigame.Game;
import net.genesishub.gFeatures.API.Minigame.Resource;
import net.genesishub.gFeatures.API.Minigame.Teams;

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

public class Listeners {
	Teams Blue;
	Teams Orange;
	Arena currentarena;
	Game hideandseek;
	Resource resource;
	public void onEnable(){
		Bukkit.getLogger().info("CTF enabled. What's up?");
		Blue = new Teams(ChatColor.DARK_AQUA + "Blue");
		Orange = new Teams(ChatColor.GOLD + "Orange");
		hideandseek = new Game("CTF", 2);
		hideandseek.addTeam(Blue);
		hideandseek.addTeam(Orange);
		resource = new Resource();
	}
	public void onDisable(){
		Bukkit.getLogger().info("CTF disabled. Bye!");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		hideandseek.addPlayer(event.getPlayer());
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		hideandseek.removePlayer(event.getPlayer());
	}
	public boolean checkStartTwo(){
		if(Blue.length() >= 1 && Orange.length() >= 1){
			return true;
		}
		return false;
	}
}
