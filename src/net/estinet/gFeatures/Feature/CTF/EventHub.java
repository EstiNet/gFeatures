package net.estinet.gFeatures.Feature.CTF;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Feature.CTF.EventBase.Dead;
import net.estinet.gFeatures.Feature.CTF.EventBase.Join;
import net.estinet.gFeatures.Feature.CTF.EventBase.Leave;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

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
	Join join = new Join();
	Leave leave = new Leave();
	Dead d = new Dead();
	public void onPlayerJoin(PlayerJoinEvent event){
		join.init(event);
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		leave.init(event);
	}
	public void onOpenInventory(InventoryOpenEvent event) {
		event.setCancelled(true);
	}
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
		if(event.getEntityType().equals(EntityType.PLAYER)){
			Player p = (Player) event.getEntity();
			if(Basic.modes.get(p.getUniqueId()).equals(Mode.WAITING)){
				event.setCancelled(true);
			}
			else if(Basic.modes.get(p.getUniqueId()).equals(Mode.STARTED)){
				if(event.getDamager().getType().equals(EntityType.PLAYER)){
					Player pl = (Player) event.getDamager();
					if(Basic.teams.get(p.getUniqueId()).equals(Team.BLUE) && Basic.teams.get(pl.getUniqueId()).equals(Team.BLUE) || Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE) && Basic.teams.get(pl.getUniqueId()).equals(Team.ORANGE)){
						event.setCancelled(true);
					}
					else{
						int health = (int) p.getHealth();
						double damage = event.getDamage();
						if(health - damage <= 0){
							event.setCancelled(true);
							Integer deaths = Basic.deaths.get(p.getUniqueId());
							deaths++;
							Basic.deaths.remove(p.getUniqueId());
							Basic.deaths.put(p.getUniqueId(), deaths);
							
							Integer kills = Basic.kills.get(pl.getUniqueId());
							kills++;
							Basic.kills.remove(pl.getUniqueId());
							Basic.kills.put(pl.getUniqueId(), kills);
							
							d.init(p);
						}
					}
				}
			}
		}
		else{
			return;
		}
	}
}
