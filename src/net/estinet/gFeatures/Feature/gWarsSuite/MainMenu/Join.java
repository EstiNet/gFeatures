package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

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

public class Join {
	ActionAPI aapi = new ActionAPI();
	Statistics stats = new Statistics();
	public void start(PlayerJoinEvent event){
		aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Welcome to the " + ChatColor.GOLD + "gWars " + ChatColor.AQUA + "Beta! Code version: " + Basic.getFeature("gWarsSuite").getVersion());
		//TODO Player cinematic
		Player p = event.getPlayer();
		ClearInventory ci = new ClearInventory();
		ci.clearInv(event.getPlayer());
		Location spawnonjoin = new Location(Bukkit.getServer().getWorld("gWars"), 350.3, 103.0, -59.3);
		p.teleport(spawnonjoin);
		p.setGameMode(GameMode.ADVENTURE);
		
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "speed walking 5 "+ p.getName());
		
		
		p.setWalkSpeed((float) 0.5);
		
		/*for(Player sp : Bukkit.getOnlinePlayers()){
			if(stats.getMode(sp).equals(gWarsMode.MAINMENU) ||  stats.getMode(sp).equals(gWarsMode.GUNMENU) || stats.getMode(sp).equals(gWarsMode.SPAWNMENU) || stats.getMode(sp).equals(gWarsMode.TEAMMENU)){
				p.hidePlayer(sp);
			}
		}
		for (Player players : Bukkit.getOnlinePlayers()){
            players.hidePlayer(p);
        }*///TODO NEED IT LATER MAYBE
		
		ItemStack item1 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.CREEPER.ordinal());
		SkullMeta item1meta = (SkullMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.GOLD + "Singleplayer");
		item1.setItemMeta(item1meta);
		
		ItemStack item2 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta item2meta = (SkullMeta) item2.getItemMeta();
		item2meta.setDisplayName(ChatColor.GOLD + "Multiplayer");
		item2.setItemMeta(item2meta);
		
		p.getInventory().setItem(0, item1);
		p.getInventory().setItem(1, item2);
		
		
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode 2 "+ p.getName());
        	}
        }, 20L);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		p.playSound(p.getLocation(), "Kime&Vexento-Climb(Fixed)", 500, 1);
        	}
        }, 200L);
	}
	public void end(Player p){
		for (Player players : Bukkit.getOnlinePlayers()){
            players.showPlayer(p);
        }
	}
}
