package net.estinet.gFeatures.Feature.gWarsSuite;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Feature.gWarsSuite.Configs.CrackshotConfiguration;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.CaptureState;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.CompassLoop;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Point;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Team;

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

public class Enable {
	public static void onEnable(){
		Bukkit.getLogger().info("[gFeatures-gWarsSuite]gWarsSuite enabled! Running core version: " + Basic.getFeature("gWarsSuite").getVersion() + "!");
		Basic.addPlayerSection("gWars", "");
		Basic.addPlayerSection("gWars.Mode", "NONE");
		Basic.addPlayerSection("gWars.Kills", "1");
		Basic.addPlayerSection("gWars.Deaths", "0");
		ConfigHub ch = new ConfigHub();
		ch.setupConfig();
		
		Constants.multiplayerpossession.put(Constants.innisfilhighway, Team.BLUE);
		Constants.multiplayerpossession.put(Constants.kloynehighway, Team.ORANGE);
		Constants.multiplayerpossession.put(Constants.bridge, Team.NEUTRAL);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		CompassLoop cl = new CompassLoop();
        		cl.updateAll();
        	}
        }, 40L, 40L);
		
		CrackshotConfiguration cc = new CrackshotConfiguration();
		try {
			cc.Initialize(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Point point : Constants.multiplayerpossession.keySet()){
			if(Constants.multiplayerpossession.get(point).equals(Team.BLUE)){
				point.setBlue();
			}
			else if(Constants.multiplayerpossession.get(point).equals(Team.ORANGE)){
				point.setOrange();
			}
			else if(Constants.multiplayerpossession.get(point).equals(Team.NEUTRAL)){
				point.setNeutral();
			}
		}
	}
}
