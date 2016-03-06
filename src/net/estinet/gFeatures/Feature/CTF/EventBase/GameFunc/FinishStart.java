package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Team;
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

public class FinishStart {
	public void finish(){
		CTFScore ctfs = new CTFScore();
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setScoreboard(ctfs.Initialize(p));
			if(Basic.teams.get(p.getUniqueId()).equals(Team.BLUE)){
				p.teleport(Basic.bluespawn);
			}
			else{
				p.teleport(Basic.orangespawn);
			}
		}
	}
}
