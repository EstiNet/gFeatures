package net.estinet.gFeatures.Feature.Spleef;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.SpectateProcess;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.CompassLoop;

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
	static ConfigHub ch = new ConfigHub();
	public static void onEnable(){
		Bukkit.getLogger().info("[Spleef] Enabled!");
		ch.setupConfig();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		for(Player p : Bukkit.getOnlinePlayers()){
        			if(p.getLocation().getY() < 26 && !SpectateProcess.spectators.contains(p.getUniqueId())){
        				SpectateProcess.addSpectator(p);
        				p.teleport(SMap.spectate);
        				Spleef.howFar.push(p.getUniqueId());
        				Spleef.stillIn.remove(p.getUniqueId());
        				if(Spleef.stillIn.size() < 2){
        					FusionPlay.currentGame.finishGame(false);
        				}
        			}
        		}
        	}
        }, 10L, 10L);
	}
}
