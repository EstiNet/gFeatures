package net.estinet.gFeatures.Feature.CTF;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Feature.CTF.EventBase.Dead;
import net.estinet.gFeatures.Feature.CTF.EventBase.FlagHit;
import net.estinet.gFeatures.Feature.CTF.EventBase.Join;
import net.estinet.gFeatures.Feature.CTF.EventBase.Leave;
import net.estinet.gFeatures.Feature.CTF.Holo.SpawnMenu;
import net.genesishub.gFeatures.API.Messaging.ActionAPI;

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
	FlagHit fh = new FlagHit();
	SpawnMenu sm = new SpawnMenu();
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
			if(Basic.modes.get(p.getUniqueId()).equals(PlayerMode.WAITING) || Basic.modes.get(p.getUniqueId()).equals(PlayerMode.SELECT)){
				event.setCancelled(true);
			}
			else if(Basic.modes.get(p.getUniqueId()).equals(PlayerMode.INGAME)){
				if(event.getDamager().getType().equals(EntityType.PLAYER)){
					Player pl = (Player) event.getDamager();
					if((Basic.teams.get(p.getUniqueId()).equals(Team.BLUE) && Basic.teams.get(pl.getUniqueId()).equals(Team.BLUE)) || (Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE) && Basic.teams.get(pl.getUniqueId()).equals(Team.ORANGE))){
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
							
							Bukkit.broadcastMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "Kill" + ChatColor.AQUA +"]" + ChatColor.DARK_AQUA + event.getDamager().getName() + " killed " + event.getEntity().getName() + "!");
							
							d.init(p);
						}
					}
					
				}
			}
		}
		else{
			if(event.getEntity().getType().equals(EntityType.ENDER_CRYSTAL)){
					event.setCancelled(true);
					fh.init(event.getEntity().getLocation(), (Player) event.getDamager());
				}
		}
	}
	public void onPlayerMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if(Basic.modes.get(p.getUniqueId()).equals(PlayerMode.SELECT) && (!event.getTo().getBlock().equals(event.getPlayer().getLocation().getBlock()))){
			event.setCancelled(true);
		}
		else if(Basic.modes.get(p.getUniqueId()).equals(PlayerMode.INGAME)){
			if(p.getLocation().getBlockY() >= 60){
				ActionAPI aapi = new ActionAPI();
				aapi.sendActionbar(p, ChatColor.AQUA + "Can't go any higher m8!");
				event.setCancelled(true);
			}
		}
	}
	public void onPlayerDrop(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}
	public void onPlayerPickup(PlayerPickupItemEvent event) {
		event.setCancelled(true);
	}
	public void onPlayerInteract(PlayerInteractEvent event){
		if(Basic.modes.get(event.getPlayer().getUniqueId()).equals(PlayerMode.SELECT)){
			sm.interact(event);
		}
	}
	public void onPlayerDeath(PlayerDeathEvent event) {
		if(event.getEntity() instanceof Player){
		if(Basic.modes.get(event.getEntity().getUniqueId()).equals(PlayerMode.WAITING)){
			event.getEntity().setHealth(20);
			
			event.getEntity().teleport(Basic.waitspawn);
			Player player = event.getEntity();
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable(){ public void run() {
		        if(event.getEntity().isDead())
		            player.setHealth(20);
		    }});
		}
		else if(Basic.modes.get(event.getEntity().getUniqueId()).equals(PlayerMode.SELECT)){
			event.getEntity().setHealth(20);
			
			if(Basic.teams.get(event.getEntity().getUniqueId()).equals(Team.BLUE)){
				event.getEntity().teleport(Basic.bluespawn);
			}
			else if(Basic.teams.get(event.getEntity().getUniqueId()).equals(Team.ORANGE)){
				event.getEntity().teleport(Basic.orangespawn);
			}
			Player player = event.getEntity();
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable(){ public void run() {
		        if(event.getEntity().isDead())
		            player.setHealth(20);
		    }});
		}
		else if(Basic.modes.get(event.getEntity().getUniqueId()).equals(PlayerMode.INGAME)){
			d.init(event.getEntity());
		}
		}
	}
}
