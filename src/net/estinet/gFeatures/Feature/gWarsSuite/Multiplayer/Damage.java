package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

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

public class Damage {
	Source s = new Source();
	Statistics stats = new Statistics();
	public void onEntityDamage(EntityDamageByEntityEvent event){
		if((OrangeTeam.hasPlayer((Player) event.getDamager()) &&  OrangeTeam.hasPlayer((Player) event.getEntity())) || (BlueTeam.hasPlayer((Player) event.getDamager()) &&  BlueTeam.hasPlayer((Player) event.getEntity()))){
			event.setCancelled(true);
		}
		else{
			Player death = (Player) event.getEntity();
			Damageable d = (Damageable) death;
			int health = (int) d.getHealth();
			double damage = event.getDamage();
			if(health - damage <= 0){
				stats.addDeaths((Player)event.getEntity(), 1);
				stats.addKill((Player)event.getDamager(), 1);
				s.flushAll();
			}
		}
	}
	public void onWeaponDamage(WeaponDamageEntityEvent event){
		if((OrangeTeam.hasPlayer((Player) event.getPlayer()) &&  OrangeTeam.hasPlayer((Player) event.getVictim())) || (BlueTeam.hasPlayer((Player) event.getPlayer()) &&  BlueTeam.hasPlayer((Player) event.getVictim()))){
			event.setCancelled(true);
		}
		else{
			Player death = (Player) event.getVictim();
			Damageable d = (Damageable) death;
			int health = (int) d.getHealth();
			double damage = event.getDamage();
			if(health - damage <= 0){
				stats.addDeaths((Player)event.getVictim(), 1);
				stats.addKill((Player)event.getPlayer(), 1);
				s.flushAll();
			}
		}
	}
}
