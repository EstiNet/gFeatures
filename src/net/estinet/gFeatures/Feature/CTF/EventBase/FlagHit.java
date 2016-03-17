package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Team;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.CTF.Holo.CTFScore;

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

public class FlagHit {
	ActionAPI aapi = new ActionAPI();
	CTFScore ctfs = new CTFScore();
	public void init(Location loc, Player p){
		if((loc.getBlockX() == Basic.blueflag.getBlockX() && loc.getBlockY() == Basic.blueflag.getBlockY() && loc.getBlockZ() == Basic.blueflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE)) && Basic.blueflagger == null){
			try{
				
			}
			catch(Exception e){
			Action.sendAllTitle(ChatColor.GOLD + p.getName() + " has taken the blue flag!", ChatColor.BOLD + "Fireworks will trace " + p.getName() + "!", 20, 40, 20);
			aapi.sendActionbar(p, ChatColor.AQUA + "Get back to your base and punch the ender crystal to capture the flag!");
			Basic.blueflagger = p;
			//Captured the blue flag
			}
		}
		else if((loc.getBlockX() == Basic.orangeflag.getBlockX() && loc.getBlockY() == Basic.orangeflag.getBlockY() && loc.getBlockZ() == Basic.orangeflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.BLUE)) && Basic.orangeflagger == null){
			Action.sendAllTitle(ChatColor.DARK_AQUA + p.getName() + " has taken the orange flag!", ChatColor.BOLD + "Fireworks will trace " + p.getName() + "!", 20, 40, 20);
			aapi.sendActionbar(p, ChatColor.AQUA + "Get back to your base and punch the ender crystal to capture the flag!");
			Basic.orangeflagger = p;
			//Captured the orange flag
		}
		else if(loc.getBlockX() == Basic.blueflag.getBlockX() && loc.getBlockY() == Basic.blueflag.getBlockY() && loc.getBlockZ() == Basic.blueflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.BLUE) && Basic.orangeflagger.getName().equals(p.getName())){
			Action.sendAllTitle(ChatColor.DARK_AQUA + p.getName() + " has captured the orange flag!", "", 20, 40, 20);
			Basic.orangeflagger = null;
			Basic.blueflags += 1;
			Integer capture = Basic.flagcaptures.get(p.getUniqueId());
			Basic.flagcaptures.remove(p.getUniqueId());
			Basic.flagcaptures.put(p.getUniqueId(), capture + 1);
			for(Player ps : Bukkit.getOnlinePlayers()){
				ps.setScoreboard(ctfs.Initialize(ps));
			}
			//Fully Captured the orange flag
		}
		else if(loc.getBlockX() == Basic.orangeflag.getBlockX() && loc.getBlockY() == Basic.orangeflag.getBlockY() && loc.getBlockZ() == Basic.orangeflag.getBlockZ() && Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE) && Basic.blueflagger.getName().equals(p.getName())){
			Action.sendAllTitle(ChatColor.GOLD + p.getName() + " has captured the blue flag!", "", 20, 40, 20);
			Basic.blueflagger = null;
			Basic.orangeflags += 1;
			Integer capture = Basic.flagcaptures.get(p.getUniqueId());
			Basic.flagcaptures.remove(p.getUniqueId());
			Basic.flagcaptures.put(p.getUniqueId(), capture+1);
			for(Player ps : Bukkit.getOnlinePlayers()){
				ps.setScoreboard(ctfs.Initialize(ps));
			}
			//Fully Captured the blue flag
		}
	}
}
