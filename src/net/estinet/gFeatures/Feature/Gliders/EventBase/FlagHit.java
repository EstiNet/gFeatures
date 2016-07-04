package net.estinet.gFeatures.Feature.Gliders.EventBase;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
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
import net.estinet.gFeatures.Feature.Gliders.Basic;
import net.estinet.gFeatures.Feature.Gliders.Team;
import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.Action;

public class FlagHit {
	ActionAPI aapi = new ActionAPI();
	public void init(Location loc, Player p){
		if(loc.getBlockX() == Basic.flag.getBlockX() && loc.getBlockY() == Basic.flag.getBlockY() && loc.getBlockZ() == Basic.flag.getBlockZ() && ((Basic.teams.get(p.getUniqueId()).equals(Team.BLUE) && !Basic.swap) || (Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE) && Basic.swap)) && Basic.flagger == null){
			Action.sendAllTitle(ChatColor.GOLD + p.getName() + " has taken the flag!", ChatColor.BOLD + "Fireworks will trace " + p.getName() + "!", 20, 40, 20);
			aapi.sendActionbar(p, ChatColor.AQUA + "Jump off the island to secure victory!");
			Basic.flagger = p;
		}
	}
}
