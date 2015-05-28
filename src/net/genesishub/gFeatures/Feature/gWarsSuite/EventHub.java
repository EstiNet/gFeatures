package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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

public class EventHub {
	Join mm = new Join();
	public void onPlayerJoin(PlayerJoinEvent event){
		mm.start(event);
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		Player p = event.getPlayer();
		//MAKE SURE YOU RESET MODE
	}
	public void onPlayerOpenInventory(InventoryOpenEvent event){
		if(Basic.getgPlayer(event.getPlayer().getName()).getValue("gWars.Mode").equals(gWarsMode.MAINMENU.toString())){
			
		}
	}
}
