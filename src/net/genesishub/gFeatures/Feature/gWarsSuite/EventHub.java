package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.API.Messaging.ActionAPI;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Interaction;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Inventory;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Join;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.MenuDamage;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Damage;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

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
	ActionAPI aapi = new ActionAPI();
	public void onPlayerJoin(PlayerJoinEvent event){
		stats.setMode(event.getPlayer(), gWarsMode.MAINMENU);
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
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
		if(event.getDamager() instanceof Player && event.getEntity() instanceof Player){
			if(stats.getMode((Player)event.getEntity()).equals(gWarsMode.MAINMENU) || stats.getMode((Player) event.getEntity()).equals(gWarsMode.GUNMENU) || stats.getMode(event.getEntity()).equals(gWarsMode.TEAMMENU) || stats.getMode(event.getEntity()).equals(gWarsMode.SPAWNMENU)){
				MenuDamage d = new MenuDamage();
				d.onEntityDamage(event);
			}
			else if(stats.getMode(event.getDamager()).equals(gWarsMode.TEAM)){
				Damage d = new Damage();
				d.onEntityDamage(event);
			}
		}
	}
	public void onWeaponDamageEntity(WeaponDamageEntityEvent event){
		if(event.getDamager() instanceof Player && event.getVictim() instanceof Player){
			if(stats.getMode((Player)event.getVictim()).equals(gWarsMode.MAINMENU) || stats.getMode((Player) event.getVictim()).equals(gWarsMode.GUNMENU) || stats.getMode(event.getVictim()).equals(gWarsMode.TEAMMENU) || stats.getMode(event.getVictim()).equals(gWarsMode.SPAWNMENU)){
				MenuDamage d = new MenuDamage();
				d.onWeaponDamage(event);
			}
			else if(stats.getMode(event.getDamager()).equals(gWarsMode.TEAM)){
				Damage d = new Damage();
				d.onWeaponDamage(event);
			}
		}
	}
	public void onPlayerItemHeld(PlayerItemHeldEvent event){
		if(stats.getMode((Player)event.getPlayer()).equals(gWarsMode.GUNMENU)){
			Constants.loredump.put(event.getPlayer(), event.getPlayer().getItemInHand().getItemMeta().getLore().get(0));
			aapi.sendActionbar(event.getPlayer(), Constants.loredump.get(event.getPlayer()));
		}
	}
	public void onInventoryClick(InventoryClickEvent event){
		if(stats.getMode((Player)event.getWhoClicked()).equals(gWarsMode.MAINMENU) || stats.getMode((Player)event.getWhoClicked()).equals(gWarsMode.GUNMENU) || stats.getMode((Player)event.getWhoClicked()).equals(gWarsMode.TEAMMENU) || stats.getMode((Player)event.getWhoClicked()).equals(gWarsMode.SPAWNMENU)){
			event.setCancelled(true);
		}
	}
	public void onEntityExplode(EntityExplodeEvent e) {
        for (Block b : e.blockList()) {
                final BlockState state = b.getState();
                b.setType(Material.AIR);
                int delay = 20;
                if ((b.getType() == Material.SAND) || (b.getType() == Material.GRAVEL)) {
                        delay += 1;
                }
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
                        public void run() {
                                state.update(true, false);
                        }
                }, delay);
        }
}
}
