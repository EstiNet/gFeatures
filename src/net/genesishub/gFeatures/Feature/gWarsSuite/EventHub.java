package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Interaction;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Inventory;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Join;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
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
	Statistics stats = new Statistics();
	Inventory inv = new Inventory();
	Interaction interact = new Interaction();
	public void onPlayerJoin(PlayerJoinEvent event){
		mm.start(event);
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		Player p = event.getPlayer();
		stats.setMode(p, gWarsMode.NONE);
		BlueTeam.removePlayer(event.getPlayer());
		OrangeTeam.removePlayer(event.getPlayer());
	}
	public void onPlayerOpenInventory(InventoryOpenEvent event){
		if(stats.getMode((Player) event.getPlayer()).equals(gWarsMode.MAINMENU) || stats.getMode((Player)event.getPlayer()).equals(gWarsMode.GUNMENU) || stats.getMode((Player)event.getPlayer()).equals(gWarsMode.TEAMMENU) || stats.getMode((Player)event.getPlayer()).equals(gWarsMode.SPAWNMENU)){
			inv.prevent(event);
		}
	}
	public void onPlayerInteract(PlayerInteractEvent event){
		if(stats.getMode(event.getPlayer()).equals(gWarsMode.MAINMENU) || stats.getMode(event.getPlayer()).equals(gWarsMode.GUNMENU) || stats.getMode(event.getPlayer()).equals(gWarsMode.TEAMMENU) || stats.getMode(event.getPlayer()).equals(gWarsMode.SPAWNMENU)){
			interact.intialize(event);
		}
		else if(stats.getMode(event.getPlayer()).equals(gWarsMode.TEAM)){
			
		}
	}
}
