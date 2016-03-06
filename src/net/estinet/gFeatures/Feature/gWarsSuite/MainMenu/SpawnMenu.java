package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.gWarsSuite.Constants;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;
import net.estinet.gFeatures.Feature.gWarsSuite.gWarsMode;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Team;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

public class SpawnMenu {
	Player p;
	ClearInventory ci = new ClearInventory();
	Statistics stats = new Statistics();
	ItemStack teamspawn, capturespawn, mainbase, innisfilhighwayexit, kloynehighwayexit, bridge, cancel;
	public SpawnMenu(Player player){
		p = player;
		
		cancel = createItem(Material.BARRIER, ChatColor.RED + "Back");
		
		teamspawn = createItem(Material.BEACON, ChatColor.WHITE + "Posessive Spawns");
		capturespawn = createItem(Material.BEACON, ChatColor.WHITE + "Captured Spawns");
		
		kloynehighwayexit = createItem(Material.STAINED_GLASS_PANE, ChatColor.GOLD + "Kloyne Highway Exit");
		innisfilhighwayexit = createItem(Material.STAINED_GLASS_PANE, ChatColor.AQUA + "Innisfil Highway Exit");
		bridge = createItem(Material.STAINED_GLASS_PANE, ChatColor.WHITE + "Bridge");
		
		if(OrangeTeam.hasPlayer(p)){
			mainbase = createItem(Material.STAINED_GLASS_PANE, ChatColor.GOLD + "Kloyne Military Base");
		}
		else{
			mainbase = createItem(Material.STAINED_GLASS_PANE, ChatColor.AQUA + "Innisfil Military Base");
		}
	}
	public void intialize(){
		ci.clearInv(p);
		
		p.getInventory().setItem(0, teamspawn);
		p.getInventory().setItem(1, capturespawn);
	}
	public void interact(PlayerInteractEvent event){
		Player p = event.getPlayer();
		
		if(p.getItemInHand().equals(teamspawn)){
			teamMenu();
		}
		else if(p.getItemInHand().equals(capturespawn)){
			captureMenu();
		}
		else if(p.getItemInHand().equals(cancel)){
			intialize();
		}
		else{
			if(p.getItemInHand().equals(mainbase)){
				if(OrangeTeam.hasPlayer(p)){
					p.sendMessage(ChatColor.GRAY + "[Spawn] Spawn place will be the" + ChatColor.GOLD + " Kloyne military base" + ChatColor.GRAY + ".");
					Constants.spawndump.put(p.getName(), Constants.orangebase);
					finali();
				}
				else{
					p.sendMessage(ChatColor.GRAY + "[Spawn] Spawn place will be the" + ChatColor.DARK_AQUA + " Innisfil military base" + ChatColor.GRAY + ".");
					Constants.spawndump.put(p.getName(), Constants.bluebase);
					finali();
				}
			}
			else if(p.getItemInHand().equals(bridge)){
				if(Constants.multiplayerpossession.get(Constants.bridge).equals(Team.ORANGE)){
					if(OrangeTeam.hasPlayer(p)){
						p.sendMessage(ChatColor.GRAY + "[Spawn] Spawn place will be the" + ChatColor.GOLD + " Bridge" + ChatColor.GRAY + ".");
						Constants.spawndump.put(p.getName(), Constants.bridge.getSpawn());
						finali();
					}
					else{
						p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is captured by" + ChatColor.GOLD + " Kloyne" + ChatColor.GRAY + ".");
					}
				}
				else if(Constants.multiplayerpossession.get(Constants.bridge).equals(Team.BLUE)){
					if(BlueTeam.hasPlayer(p)){
						p.sendMessage(ChatColor.GRAY + "[Spawn] Spawn place will be the" + ChatColor.DARK_AQUA + " Bridge" + ChatColor.GRAY + ".");
						Constants.spawndump.put(p.getName(), Constants.bridge.getSpawn());
						finali();
					}
					else{
						p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is captured by" + ChatColor.DARK_AQUA + " Innisfil" + ChatColor.GRAY + ".");
					}
				}
				else if(Constants.multiplayerpossession.get(Constants.bridge).equals(Team.NEUTRAL)){
					p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is" + ChatColor.WHITE + " Neutral" + ChatColor.GRAY + ".");
				}
			}
			else if(p.getItemInHand().equals(innisfilhighwayexit)){
				if(Constants.multiplayerpossession.get(Constants.innisfilhighway).equals(Team.ORANGE)){
					if(OrangeTeam.hasPlayer(p)){
						p.sendMessage(ChatColor.GRAY + "[Spawn] Spawn place will be the" + ChatColor.GOLD + " Innisfil Highway Exit" + ChatColor.GRAY + ".");
						Constants.spawndump.put(p.getName(), Constants.innisfilhighway.getSpawn());
						finali();
					}
					else{
						p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is captured by" + ChatColor.GOLD + " Kloyne" + ChatColor.GRAY + ".");
					}
				}
				else if(Constants.multiplayerpossession.get(Constants.innisfilhighway).equals(Team.BLUE)){
					if(BlueTeam.hasPlayer(p)){
						p.sendMessage(ChatColor.GRAY + "[Spawn] Spawn place will be the" + ChatColor.DARK_AQUA + " Innisfil Highway Exit" + ChatColor.GRAY + ".");
						Constants.spawndump.put(p.getName(), Constants.innisfilhighway.getSpawn());
						finali();
					}
					else{
						p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is captured by" + ChatColor.DARK_AQUA + " Innisfil" + ChatColor.GRAY + ".");
					}
				}
				else if(Constants.multiplayerpossession.get(Constants.innisfilhighway).equals(Team.NEUTRAL)){
					p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is " + ChatColor.WHITE + " Neutral" + ChatColor.GRAY + ".");
				}
			}
			else if(p.getItemInHand().equals(kloynehighwayexit)){
				if(Constants.multiplayerpossession.get(Constants.kloynehighway).equals(Team.ORANGE)){
					if(OrangeTeam.hasPlayer(p)){
						p.sendMessage(ChatColor.GRAY + "[Spawn] Spawn place will be the" + ChatColor.GOLD + " Kloyne Highway Exit" + ChatColor.GRAY + ".");
						Constants.spawndump.put(p.getName(), Constants.kloynehighway.getSpawn());
						finali();
					}
					else{
						p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is captured by" + ChatColor.GOLD + " Kloyne" + ChatColor.GRAY + ".");
					}
				}
				else if(Constants.multiplayerpossession.get(Constants.kloynehighway).equals(Team.BLUE)){
					if(BlueTeam.hasPlayer(p)){
						p.sendMessage(ChatColor.GRAY + "[Spawn] Spawn place will be the" + ChatColor.DARK_AQUA + " Kloyne Highway Exit" + ChatColor.GRAY + ".");
						Constants.spawndump.put(p.getName(), Constants.kloynehighway.getSpawn());
						finali();
					}
					else{
						p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is captured by" + ChatColor.DARK_AQUA + " Innisfil" + ChatColor.GRAY + ".");
					}
				}
				else if(Constants.multiplayerpossession.get(Constants.kloynehighway).equals(Team.NEUTRAL)){
					p.sendMessage(ChatColor.GRAY + "[Spawn] Can't spawn there! The point is" + ChatColor.WHITE + " Neutral" + ChatColor.GRAY + ".");
				}
			}
		}
	}
	private void teamMenu(){
		ci.clearInv(p);
		
		p.getInventory().setItem(0, mainbase);
		p.getInventory().setItem(8, cancel);
	}
	private void captureMenu(){
		ci.clearInv(p);
		
		p.getInventory().setItem(0, bridge);
		p.getInventory().setItem(1, innisfilhighwayexit);
		p.getInventory().setItem(2, kloynehighwayexit);
		p.getInventory().setItem(8, cancel);
	}
	private void finali(){
		stats.setMode(p, gWarsMode.GUNMENU);
		GunMenu gm = new GunMenu();
		gm.setup(p);
	}
	public ItemStack createItem(Material material, String name, String ... lore){
		ItemStack item = new ItemStack(material, 1);
		List<String> lores = new ArrayList<>();
		for(String lor : lore){
		lores.add(lor);
		}
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lores);
		item.setItemMeta(meta);
		return item;
	}
}
