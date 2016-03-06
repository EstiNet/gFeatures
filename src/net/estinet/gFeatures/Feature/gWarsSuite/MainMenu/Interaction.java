package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu;

import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;
import net.estinet.gFeatures.Feature.gWarsSuite.gWarsMode;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

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

public class Interaction {
	Statistics stats = new Statistics();
	Inventory inv = new Inventory();
	TeamMenu tm = new TeamMenu();
	GunMenu gm = new GunMenu();
	public void intialize(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(stats.getMode(p).equals(gWarsMode.MAINMENU)){
			inv.interact(event);
			event.setCancelled(true);
		}
		else if(stats.getMode(p).equals(gWarsMode.TEAMMENU)){
			tm.interact(event);
			event.setCancelled(true);
		}
		else if(stats.getMode(p).equals(gWarsMode.GUNMENU)){
			gm.interaction(event);
			event.setCancelled(true);
		}
		else if(stats.getMode(p).equals(gWarsMode.SPAWNMENU)){
			SpawnMenu sm = new SpawnMenu(p);
			sm.interact(event);
			event.setCancelled(true);
		}
	}
}
