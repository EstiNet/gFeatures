package net.estinet.gFeatures.Feature.FusionPlay;

import org.bukkit.Bukkit;
import org.bukkit.Server.Spigot;
import org.bukkit.WorldCreator;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.EnabledHandler;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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
	static ConfigHub ch = new ConfigHub();
	public static void onEnable(){
		ch.setupConfig();
		Bukkit.getLogger().info("[FusionPlay] Enabled!");
		FusionPlay.selectGame();
		FusionPlay.currentGame.loadMap();
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				//Auto Implementation of World Loading
				if(FusionPlay.currentGame.getSettings().usesAutoLoadMap()){
					WorldCreator cs = new WorldCreator(FusionPlay.currentGame.getSettings().getDefaultMapName());
					Bukkit.getServer().createWorld(cs);
				}
				
				Bukkit.getWorld(FusionPlay.currentGame.getSettings().getDefaultMapName()).setTime(FusionPlay.currentGame.getSettings().getStartTimeOfDay());
				
				if(FusionPlay.currentGame.getSettings().usesAlwaysSetTime()){
					Bukkit.getWorld(FusionPlay.currentGame.getSettings().getDefaultMapName()).setGameRuleValue("doDaylightCycle", "false");
				}
				
				FusionPlay.currentGame.worldLoaded();
				
				FusionPlay.currentGame.getFusionMap().reassign();
				
				EnabledHandler.init();
			}
		}, 50L);
	}
}
