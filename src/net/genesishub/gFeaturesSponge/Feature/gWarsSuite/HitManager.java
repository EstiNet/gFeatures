package net.genesishub.gFeatures.Feature.gWarsSuite;

import java.io.File;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

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

public class HitManager {
	File f = new File("KillsDeaths.xml");
	StatsRetrieve sr = new StatsRetrieve();
	StatsManager sm = new StatsManager();
	Constants cons = new Constants();
	public void EntityDamageByOther(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player damaged = (Player)event.getEntity();
            Player damager = (Player)event.getDamager();

            if(Constants.bt.contains(damaged.getName()) && Constants.bt.contains(damager.getName())) { // check if both damaged and damager are on blue team
                event.setCancelled(true); // cancel the event, so no damage will be dealt.
            }

            if(Constants.ot.contains(damaged.getName()) && Constants.ot.contains(damager.getName())) { // same for red team
                event.setCancelled(true);
            }}
	}
	public void WeaponDamage(WeaponDamageEntityEvent event){
		if(true) {
            Player damaged = (Player)event.getVictim();
            Player damager = (Player)event.getPlayer();
            try{
    			Player death = (Player) event.getVictim();
    			Damageable d = (Damageable) death;
    			int health = (int) d.getHealth();
    			double damage = event.getDamage();
    			if(health - damage <= 0){
    			death.getInventory().remove(Material.CHEST);
    			death.getInventory().remove(Material.STAINED_GLASS);
    			Player death1 = (Player) event.getVictim();
    			Player cause1 = event.getPlayer();
    			sm.giveKills(cause1, 1);
    			sm.giveDeaths(death1, 1);
    			}
            if(Constants.bt.contains(damaged.getName()) && Constants.bt.contains(damager.getName())) { // check if both damaged and damager are on blue team
                event.setCancelled(true); // cancel the event, so no damage will be dealt.
            }
            if(Constants.ot.contains(damaged.getName()) && Constants.ot.contains(damager.getName())) { // same for red team
                event.setCancelled(true);
            }
			}catch(Exception e){
				e.printStackTrace();
			}
        }
	}
}
