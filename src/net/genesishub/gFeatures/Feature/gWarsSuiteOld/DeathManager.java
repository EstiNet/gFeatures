package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import java.io.File;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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

public class DeathManager {
	File f = new File("KillsDeaths.xml");
	StatsRetrieve sr = new StatsRetrieve();
	Constants cons = new Constants();
	Administration admin = new Administration();
	StatsManager sm = new StatsManager();
	public void ManageDeath(final Player p, PlayerDeathEvent event){
		p.getInventory().remove(Material.CHEST);
		p.getInventory().getHelmet().setType(Material.AIR);
		Constants.arena.remove(p.getName());
		Constants.gunin.remove(p.getName());
		try{
		if(event.getEntity() instanceof Player && event.getEntity().getKiller() instanceof Player){
		Player death = event.getEntity();
		Player cause = death.getKiller();
		sm.giveKills(cause, 1);
		sm.giveDeaths(death, 1);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
