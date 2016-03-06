package net.estinet.gFeatures.Feature.Grasslands;

import net.estinet.gFeatures.Feature.Grasslands.Scoreboard.Countdown;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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

public class EventHub{
	public void onPlayerJoin(PlayerJoinEvent event){
		Enable.grasslands.addPlayer(event.getPlayer());
		Countdown cd = new Countdown();
		event.getPlayer().setScoreboard(cd.get(event.getPlayer(), 60));
		if(Basis.mode.equals(GrasslandsMode.Waiting) || Basis.mode.equals(GrasslandsMode.Counting)){
			Enable.lobby.addPlayer(event.getPlayer());
			GameStart gs = new GameStart();
			gs.check();
		}
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		if(Basis.mode.equals(GrasslandsMode.Counting)){
			if(Bukkit.getOnlinePlayers().size() == 2){
				GameStart gs = new GameStart();
				gs.checkLeave();
			}
		}
	}
}
