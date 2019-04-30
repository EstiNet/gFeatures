package net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.Gliders.Holo.GlidersScore;
import net.estinet.gFeatures.Feature.gMusic.Music;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class FinishStart {
	public void finish(){
		GlidersScore gs = new GlidersScore();
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setScoreboard(gs.Initialize(p));
			/*if(Basic.teams.get(p.getUniqueId()).equals(Team.BLUE)){
				int random = (int) Math.floor(Math.random() * Basic.planespawn.size());
				p.teleport(Basic.planespawn.get(random));
			}
			else{
				int random = (int) Math.floor(Math.random() * Basic.towerspawn.size());
				p.teleport(Basic.towerspawn.get(random));
			}*/
			Music m = new Music();
			m.sendMusic(p, "theme", 100, "Vexento", "New Colours", "");
		}
	}
}
