package net.estinet.gFeatures.Feature.Gliders.Holo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.Gliders.Basic;
import net.estinet.gFeatures.Feature.Gliders.Mode;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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

public class Loop {
	GlidersScore gs = new GlidersScore();
	Lobby lobby = new Lobby();
	public void goThrough(){
		for(Player p : Bukkit.getServer().getOnlinePlayers()){
			if(Basic.mode.equals(Mode.STARTED) || Basic.mode.equals(Mode.ENDED)){
				gs.Initialize(p);
			}
			else if(Basic.mode.equals(Mode.WAITING)){
				lobby.Initialize(p);
			}
		}
	}
}
