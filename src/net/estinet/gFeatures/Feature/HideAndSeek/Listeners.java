package net.estinet.gFeatures.Feature.HideAndSeek;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.API.Minigame.Arena;
import net.estinet.gFeatures.API.Minigame.Game;
import net.estinet.gFeatures.API.Minigame.Resource;
import net.estinet.gFeatures.API.Minigame.Teams;

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

public class Listeners {
	Teams hider;
	Teams finder;
	Arena currentarena;
	Game hideandseek;
	Resource resource;
	public void onEnable(){
		Bukkit.getLogger().info("HideAndSeek enabled. What's up?");
		hider = new Teams(ChatColor.DARK_AQUA + "Hider");
		finder = new Teams(ChatColor.GRAY + "Finder");
		hideandseek = new Game("HideAndSeek", 2);
		hideandseek.addTeam(hider);
		hideandseek.addTeam(finder);
		resource = new Resource();
	}
	public void onDisable(){
		Bukkit.getLogger().info("HideAndSeek disabled. Bye!");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		hideandseek.addPlayer(event.getPlayer());
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		hideandseek.removePlayer(event.getPlayer());
	}
	public boolean checkStartTwo(){
		if(hider.length() >= 1 && finder.length() >= 1){
			return true;
		}
		return false;
	}
}
