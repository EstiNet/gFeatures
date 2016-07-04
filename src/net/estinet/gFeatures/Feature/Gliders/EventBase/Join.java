package net.estinet.gFeatures.Feature.Gliders.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.Gliders.Basic;
import net.estinet.gFeatures.Feature.Gliders.PlayerMode;
import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.StartStop;
import net.estinet.gFeatures.Feature.Gliders.Holo.GlidersScore;
import net.estinet.gFeatures.Feature.Gliders.Holo.Lobby;

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
	StartStop ss = new StartStop();
	Spectate s = new Spectate();
	Lobby l = new Lobby();
	GlidersScore ctfs = new GlidersScore();
	ClearInventory ci = new ClearInventory();
	public void init(PlayerJoinEvent event){
		ci.clearInv(event.getPlayer());
		event.getPlayer().setGameMode(GameMode.ADVENTURE);
		Basic.kills.put(event.getPlayer().getUniqueId(), 0);
		Basic.deaths.put(event.getPlayer().getUniqueId(), 0);
		switch(Basic.mode){
		case WAITING:
			for(Player p : Bukkit.getOnlinePlayers()){
				p.setScoreboard(l.Initialize(p));
			}
			event.getPlayer().setHealth(20);
			event.getPlayer().setSaturation(20);
			event.getPlayer().setFoodLevel(20);
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.WAITING);
			Basic.waitspawn = new Location(Bukkit.getWorld("MinigameSpawn"), 76.5, 96.5, 91.5);
			event.getPlayer().teleport(Basic.waitspawn);
			if(Bukkit.getOnlinePlayers().size() >= 2 && Basic.countdown == 60){
				Action.sendAll(ChatColor.AQUA + "Enough players! Game will be starting in 1 minute.");
				ss.start();
			}
			ItemStack is = new ItemStack(Material.COMPASS, 1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.DARK_AQUA + "Back to " + ChatColor.GOLD + "Hub");
			is.setItemMeta(im);
			event.getPlayer().getInventory().setItem(8, is);
			break;
		case ENDED:
			for(Player p : Bukkit.getOnlinePlayers()){
				p.setScoreboard(ctfs.Initialize(p));
			}
			event.getPlayer().teleport(Basic.spectatespawn);
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.SPECTATE);
			s.handler(event.getPlayer());
			event.getPlayer().setGameMode(GameMode.SPECTATOR);
			break;
		case STARTED:
			for(Player p : Bukkit.getOnlinePlayers()){
				p.setScoreboard(ctfs.Initialize(p));
			}
			event.getPlayer().teleport(Basic.spectatespawn);
			Basic.modes.put(event.getPlayer().getUniqueId(), PlayerMode.SPECTATE);
			s.handler(event.getPlayer());
			event.getPlayer().setGameMode(GameMode.SPECTATOR);
			break;
		default:
			break;
		}
	}
}
