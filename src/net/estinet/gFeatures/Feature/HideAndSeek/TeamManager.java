package net.estinet.gFeatures.Feature.HideAndSeek;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Minigame.Teams;

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

public class TeamManager {
	net.estinet.gFeatures.Feature.HideAndSeek.Listeners Listeners = new net.estinet.gFeatures.Feature.HideAndSeek.Listeners();
	public void onJoinTeam(Player player, Teams team) throws Exception{
		if(team.equals(Listeners.hideandseek.getTeam(0))){
			Listeners.hideandseek.getTeam(0).addPlayer(player);
			if(Listeners.checkStartTwo()){
			Listeners.hideandseek.checkStart();
			}
		}
		else if(team.equals(Listeners.hideandseek.getTeam(1))){
			Listeners.hideandseek.getTeam(1).addPlayer(player);
			if(Listeners.checkStartTwo()){
				Listeners.hideandseek.checkStart();
			}
		}
		else{
			Exception exception = new Exception();;
			throw exception;
		}
	}
}
