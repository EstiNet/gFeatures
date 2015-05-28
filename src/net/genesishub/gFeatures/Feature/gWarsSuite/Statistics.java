package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.API.PlayerStats.gPlayer;

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

public class Statistics {
	public int getKills(Player p){
		return Integer.parseInt(Basic.getgPlayer(p.getName()).getValue("gWars.Kills"));
	}
	public int getDeaths(Player p){
		return Integer.parseInt(Basic.getgPlayer(p.getName()).getValue("gWars.Deaths"));
	}
	public gWarsMode getMode(Player p){
		switch(Basic.getgPlayer(p.getName()).getValue("gWars.Mode")){
			case "NONE":
				return gWarsMode.NONE;
			case "MAINMENU": 
				return gWarsMode.MAINMENU;
			case "TEAM":
				return gWarsMode.TEAM;
			case "CAMPAIGN":
				return gWarsMode.CAMPAIGN;
			default:
				return gWarsMode.NONE;
		}
	}
	public void addKill(Player p){
		int kill = Integer.parseInt(Basic.getgPlayer(p.getName()).getValue("gWars.Kills"));
		kill += 1;
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Kills", Integer.toString(kill));
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
		return;
	}
	public void addDeaths(Player p){
		int kill = Integer.parseInt(Basic.getgPlayer(p.getName()).getValue("gWars.Deaths"));
		kill += 1;
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Deaths", Integer.toString(kill));
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
		return;
	}
	public void setKills(Player p, int value){
		int kill = value;
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Kills", Integer.toString(kill));
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
		return;
	}
	public void setDeaths(Player p, int value){
		int kill = value;
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Deaths", Integer.toString(kill));
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
		return;
	}
	public void setMode(Player p, gWarsMode mode){
		gPlayer gplayer = Basic.getgPlayer(p.getName());
		gplayer.setValue("gWars.Mode", mode.toString());
		Basic.removegPlayer(Basic.getgPlayer(p.getName()));
		Basic.addgPlayer(gplayer);
	}
}
