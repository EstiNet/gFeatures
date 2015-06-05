package net.genesishub.gFeatures.Feature.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Point;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Team;

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

public class Enable {
	public static void onEnable(){
		Bukkit.getLogger().info("[gFeatures-gWarsSuite]gWarsSuite enabled! Running core version: " + Basic.getFeature("gWarsSuite").getVersion() + "!");
		Basic.addPlayerSection("gWars", "");
		Basic.addPlayerSection("gWars.Kills", "0");
		Basic.addPlayerSection("gWars.Deaths", "0");
		Basic.addPlayerSection("gWars.Mode", "NONE");
		ConfigHub ch = new ConfigHub();
		ch.setupConfig();
		
		/*
		 * Intialize Points here.
		 * 
		 * */
		
		Constants.multiplayerpossession.put(Constants.innisfilhighway, Team.BLUE);
		Constants.multiplayerpossession.put(Constants.kloynehighway, Team.ORANGE);
		Constants.multiplayerpossession.put(Constants.bridge, Team.NEUTRAL);
		
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
