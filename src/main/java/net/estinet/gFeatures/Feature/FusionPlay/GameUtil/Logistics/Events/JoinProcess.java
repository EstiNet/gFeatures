package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.SpectateProcess;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.WaitingProcess;
import net.md_5.bungee.api.ChatColor;

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

public class JoinProcess {
	public static void init(PlayerJoinEvent event){
		if(FusionPlay.currentGame.getFusionState().equals(FusionState.WAITING)){
			if(FusionPlay.currentGame.getSettings().usesSpawns()){
				WaitingProcess.joinOnWait(event.getPlayer());
			}
			event.getPlayer().setGameMode(FusionPlay.currentGame.defaultGameMode);
			if(Bukkit.getServer().getOnlinePlayers().size() > 1){
				WaitingProcess.playerJoin(event);
			}
			else{
				event.getPlayer().sendTitle(ChatColor.DARK_GRAY + "Waiting for more players...", "", 10, 20, 10);
			}
		}
		else{
			SpectateProcess.addSpectator(event.getPlayer());
		}
	}
}
