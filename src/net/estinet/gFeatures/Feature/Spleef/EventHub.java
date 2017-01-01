package net.estinet.gFeatures.Feature.Spleef;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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
		if(FusionPlay.currentGame.getFusionState().equals(FusionState.WAITING)){
			Spleef.stillIn.add(event.getPlayer().getUniqueId());
		}
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		Spleef.stillIn.remove(event.getPlayer().getUniqueId());
		Spleef.howFar.remove(event.getPlayer().getUniqueId());
	}
	public void onPlayerBreak(BlockBreakEvent event) {
		event.setCancelled(true);
		Block block = event.getBlock();
		if(block.getType().equals(Material.SNOW_BLOCK)){
			block.setType(Material.AIR);
		}
	}
}
