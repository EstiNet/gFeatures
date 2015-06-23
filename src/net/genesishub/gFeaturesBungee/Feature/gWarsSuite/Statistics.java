package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.API.PlayerStats.gPlayer;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Team;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
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
		return Integer.parseInt(Basic.getgPlayer(p.getUniqueId().toString()).getValue("gWars.Kills"));
	}
	public int getDeaths(Player p){
		return Integer.parseInt(Basic.getgPlayer(p.getUniqueId().toString()).getValue("gWars.Deaths"));
	}
	public gWarsMode getMode(Entity entity){
		return Constants.mode.get(entity);
	}
	public void addKill(Player p, int num){
		int kill = Integer.parseInt(Basic.getgPlayer(p.getUniqueId().toString()).getValue("gWars.Kills"));
		kill += num;
		gPlayer gplayer = Basic.getgPlayer(p.getUniqueId().toString());
		gplayer.setValue("gWars.Kills", Integer.toString(kill));
		Basic.setgPlayer(Basic.getgPlayer(p.getUniqueId().toString()), gplayer);
		return;
	}
	public void addDeaths(Player p, int num){
		int kill = Integer.parseInt(Basic.getgPlayer(p.getUniqueId().toString()).getValue("gWars.Deaths"));
		kill += num;
		gPlayer gplayer = Basic.getgPlayer(p.getUniqueId().toString());
		gplayer.setValue("gWars.Deaths", Integer.toString(kill));
		Basic.setgPlayer(Basic.getgPlayer(p.getUniqueId().toString()), gplayer);
		return;
	}
	public void minusKill(Player p, int num){
		int kill = Integer.parseInt(Basic.getgPlayer(p.getUniqueId().toString()).getValue("gWars.Kills"));
		kill -= num;
		gPlayer gplayer = Basic.getgPlayer(p.getUniqueId().toString());
		gplayer.setValue("gWars.Kills", Integer.toString(kill));
		Basic.setgPlayer(Basic.getgPlayer(p.getUniqueId().toString()), gplayer);
		return;
	}
	public void minusDeaths(Player p, int num){
		int kill = Integer.parseInt(Basic.getgPlayer(p.getUniqueId().toString()).getValue("gWars.Deaths"));
		kill -= num;
		gPlayer gplayer = Basic.getgPlayer(p.getUniqueId().toString());
		gplayer.setValue("gWars.Deaths", Integer.toString(kill));
		Basic.setgPlayer(Basic.getgPlayer(p.getUniqueId().toString()), gplayer);
		return;
	}
	public void setKills(Player p, int value){
		int kill = value;
		gPlayer gplayer = Basic.getgPlayer(p.getUniqueId().toString());
		gplayer.setValue("gWars.Kills", Integer.toString(kill));
		Basic.setgPlayer(Basic.getgPlayer(p.getUniqueId().toString()), gplayer);
		return;
	}
	public void setDeaths(Player p, int value){
		int kill = value;
		gPlayer gplayer = Basic.getgPlayer(p.getUniqueId().toString());
		gplayer.setValue("gWars.Deaths", Integer.toString(kill));
		Basic.setgPlayer(Basic.getgPlayer(p.getUniqueId().toString()), gplayer);
		return;
	}
	public void setMode(Player p, gWarsMode mode){
		for(gWarsMode m : gWarsMode.values()){
			if(m.equals(mode)){
				Constants.mode.remove(p);
				Constants.mode.put(p, mode);
			}
		}
	}
	public Team getTeam(Player p){
		if(OrangeTeam.hasPlayer(p)){
			return Team.ORANGE;
		}
		else if(BlueTeam.hasPlayer(p)){
			return Team.BLUE;
		}
		else{
			return Team.NEUTRAL;
		}
	}
	public String getStringTeam(Player p){
		if(OrangeTeam.hasPlayer(p)){
			return ChatColor.GOLD + "Kloyne";
		}
		else if(BlueTeam.hasPlayer(p)){
			return ChatColor.DARK_AQUA + "Innisfil";
		}
		return ChatColor.WHITE + "Not in game.";
	}
}
