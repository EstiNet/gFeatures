package net.estinet.gFeatures.Feature.gWarsSuite;

import java.util.List;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.gWarsSuite.Connection.CheckConfig;
import net.estinet.gFeatures.Feature.gWarsSuite.Connection.Connection;
import net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.Interaction;
import net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.Inventory;
import net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.Join;
import net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.MenuDamage;
import net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.SpawnMenu;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Damage;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Interact;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Move;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Source;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

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

public class EventHub {
	Join mm = new Join();
	Statistics stats = new Statistics();
	Inventory inv = new Inventory();
	Interaction interact = new Interaction();
	ActionAPI aapi = new ActionAPI();
	public void onPlayerJoin(PlayerJoinEvent event){
		Connection c = new Connection();
		CheckConfig cc = new CheckConfig();
		c.Connect(c.toURL(cc.getPort(), cc.getAddress(), cc.getTablename()), cc.getUsername(), cc.getPassword(), "INSERT INTO Kills(Name, Kills)\n"+
				"SELECT * FROM (SELECT '" + event.getPlayer().getUniqueId() + "', '0') AS tmp\n"+
				"WHERE NOT EXISTS (\n"+
				"SELECT Name FROM Kills WHERE Name = '" + event.getPlayer().getUniqueId() + "'\n"+
				") LIMIT 1;\n"
			);
		c.Connect(c.toURL(cc.getPort(), cc.getAddress(), cc.getTablename()), cc.getUsername(), cc.getPassword(), "INSERT INTO Deaths(Name, Deaths)\n"+
				"SELECT * FROM (SELECT '" + event.getPlayer().getUniqueId() + "', '0') AS tmp\n"+
				"WHERE NOT EXISTS (\n"+
				"SELECT Name FROM Deaths WHERE Name = '" + event.getPlayer().getUniqueId() + "'\n"+
				") LIMIT 1;\n"
			);
		Source s = new Source();
		s.flushAll();
		stats.setMode(event.getPlayer(), gWarsMode.MAINMENU);
		mm.start(event);
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		Player p = event.getPlayer();
		stats.setMode(p, gWarsMode.NONE);
		BlueTeam.removePlayer(event.getPlayer());
		OrangeTeam.removePlayer(event.getPlayer());
		Constants.spawndump.remove(p);
		Constants.capturetrigger.remove(event.getPlayer().getName());
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
			Interact interact = new Interact();
			interact.initialize(event);
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
		if(event.getPlayer() instanceof Player && event.getVictim() instanceof Player){
			if(stats.getMode((Player)event.getVictim()).equals(gWarsMode.MAINMENU) || stats.getMode((Player) event.getVictim()).equals(gWarsMode.GUNMENU) || stats.getMode(event.getVictim()).equals(gWarsMode.TEAMMENU) || stats.getMode(event.getVictim()).equals(gWarsMode.SPAWNMENU)){
				MenuDamage d = new MenuDamage();
				d.onWeaponDamage(event);
			}
			else if(stats.getMode(event.getVictim()).equals(gWarsMode.TEAM)){
				Damage d = new Damage();
				d.onWeaponDamage(event);
			}
		}
	}
	public void onPlayerItemHeld(PlayerItemHeldEvent event){
		/*if(stats.getMode(event.getPlayer()).equals(gWarsMode.GUNMENU)){
			aapi.sendActionbar(event.getPlayer(), event.getPlayer().getInventory().getItem(event.getPreviousSlot()).getItemMeta().getLore().get(0));
		}*/
	}
	public void onInventoryClick(InventoryClickEvent event){
		if(stats.getMode((Player)event.getWhoClicked()).equals(gWarsMode.MAINMENU) || stats.getMode((Player)event.getWhoClicked()).equals(gWarsMode.GUNMENU) || stats.getMode((Player)event.getWhoClicked()).equals(gWarsMode.TEAMMENU) || stats.getMode((Player)event.getWhoClicked()).equals(gWarsMode.SPAWNMENU)){
			event.setCancelled(true);
		}
	}
	public void onEntityExplode(EntityExplodeEvent e) {
		List<Block> blocks = e.blockList();
		for (Block b : blocks){
		b.getDrops().clear();
		}
	}
	public void onPlayerRespawn(PlayerRespawnEvent event){
		Source s = new Source();
		s.flushAll();
		if(stats.getMode((Player)event.getPlayer()).equals(gWarsMode.TEAM)){
			stats.setMode(event.getPlayer(), gWarsMode.SPAWNMENU);
			SpawnMenu sm = new SpawnMenu(event.getPlayer());
			sm.intialize();
			if(BlueTeam.hasPlayer(event.getPlayer())){
				ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)3);
				event.getPlayer().getInventory().setHelmet(wool);
			}
			else if(OrangeTeam.hasPlayer(event.getPlayer())){
				ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)1);
				event.getPlayer().getInventory().setHelmet(wool);
			}
		}
	}
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	public void onPlayerMove(PlayerMoveEvent event){
		if(stats.getMode((Player)event.getPlayer()).equals(gWarsMode.TEAM)){
			Move move = new Move();
			move.initialize(event);
		}
	}
	public void onPlayerDeath(PlayerDeathEvent event){
	}
	public void onPlayerDrop(PlayerDropItemEvent event){
		if(stats.getMode((Player) event.getPlayer()).equals(gWarsMode.MAINMENU) || stats.getMode((Player)event.getPlayer()).equals(gWarsMode.GUNMENU) || stats.getMode((Player)event.getPlayer()).equals(gWarsMode.TEAMMENU) || stats.getMode((Player)event.getPlayer()).equals(gWarsMode.SPAWNMENU)){
			event.setCancelled(true);
		}
	}
}
