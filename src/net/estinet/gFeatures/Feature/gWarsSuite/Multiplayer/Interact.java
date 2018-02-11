package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.estinet.gFeatures.Feature.gWarsSuite.Constants;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;
import net.estinet.gFeatures.Feature.gWarsSuite.gWarsMode;
import net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.Join;
import net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.SpawnMenu;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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

public class Interact {
	public void initialize(PlayerInteractEvent event){
		try{
			Statistics stats = new Statistics();
			if(stats.getMode(event.getPlayer().getName()).equals(gWarsMode.TEAM)){
				Bukkit.getLogger().info("x: " + event.getClickedBlock().getLocation().getX() + " y: " + event.getClickedBlock().getLocation().getY() + " z: " + event.getClickedBlock().getLocation().getZ());
				World world = Bukkit.getServer().getWorld("gWars");
				if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getServer().getWorld("gWars"), 657, 61, -57))){//Orange
					if(!Constants.vehiclehog.contains(event.getPlayer().getUniqueId())){
						int random = (int) Math.ceil(Math.random() * 4);
						event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Fighter Jet" + ChatColor.GRAY + ".");
						switch(random){
						case 1:
							world.spawnEntity(new Location(world, 651, 61, -54), EntityType.MINECART);
							break;
						case 2:
							world.spawnEntity(new Location(world, 655, 61, -54), EntityType.MINECART);
							break;
						case 3:
							world.spawnEntity(new Location(world, 659, 61, -54), EntityType.MINECART);
							break;
						case 4:
							world.spawnEntity(new Location(world, 663, 61, -54), EntityType.MINECART);
							break;
						}
						addPlayer(event.getPlayer());
						event.setCancelled(true);
					}
					else{
						event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Please wait " + ChatColor.AQUA + "30" + ChatColor.GRAY + " seconds before spawning another vehicle.");
						event.setCancelled(true);
					}
				}
				else if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getServer().getWorld("gWars"), 24, 61, 216))){//Blue
					if(!Constants.vehiclehog.contains(event.getPlayer().getUniqueId())){
						int random = (int) Math.ceil(Math.random() * 4);
						event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Fighter Jet" + ChatColor.GRAY + ".");
						switch(random){
						case 1:
							world.spawnEntity(new Location(world, 22, 61, 210), EntityType.MINECART);
							break;
						case 2:
							world.spawnEntity(new Location(world, 22, 61, 214), EntityType.MINECART);
							break;
						case 3:
							world.spawnEntity(new Location(world, 22, 61, 218), EntityType.MINECART);
							break;
						case 4:
							world.spawnEntity(new Location(world, 22, 61, 222), EntityType.MINECART);
							break;
						}
						addPlayer(event.getPlayer());
						event.setCancelled(true);
					}
					else{
						event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Please wait " + ChatColor.AQUA + "30" + ChatColor.GRAY + " seconds before spawning another vehicle.");
						event.setCancelled(true);
					}
				}
				else{
					blueBoats(event);
					orangeBoats(event);
				}
			}
		}catch(Exception e){e.printStackTrace();}
		/*not in adventure? if(event.getAction().equals(Action.PHYSICAL) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
			event.setCancelled(true);
		}*/
	}
	public void blueBoats(PlayerInteractEvent event){
		World world = Bukkit.getServer().getWorld("gWars");
		if(event.getClickedBlock().getLocation().equals(new Location(world, 3, 61, 286))){
			if(!Constants.vehiclehog.contains(event.getPlayer().getUniqueId())){
				world.spawnEntity(new Location(world, 3, 62, 282), EntityType.BOAT);
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Boat" + ChatColor.GRAY + ".");
				addPlayer(event.getPlayer());
				event.setCancelled(true);
			}
			else{
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Please wait " + ChatColor.AQUA + "30" + ChatColor.GRAY + " seconds before spawning another vehicle.");
				event.setCancelled(true);
			}
		}
		else if(event.getClickedBlock().getLocation().equals(new Location(world, 3, 61, 294))){
			if(!Constants.vehiclehog.contains(event.getPlayer().getUniqueId())){
				world.spawnEntity(new Location(world, 4, 62, 290), EntityType.BOAT);
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Boat" + ChatColor.GRAY + ".");
				addPlayer(event.getPlayer());
				event.setCancelled(true);
			}
			else{
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Please wait " + ChatColor.AQUA + "30" + ChatColor.GRAY + " seconds before spawning another vehicle.");
				event.setCancelled(true);
			}
		}
		else if(event.getClickedBlock().getLocation().equals(new Location(world, 3, 61, 302))){
			if(!Constants.vehiclehog.contains(event.getPlayer().getUniqueId())){
				world.spawnEntity(new Location(world, 4, 62, 298), EntityType.BOAT);
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Boat" + ChatColor.GRAY + ".");
				addPlayer(event.getPlayer());
				event.setCancelled(true);
			}
			else{
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Please wait " + ChatColor.AQUA + "30" + ChatColor.GRAY + " seconds before spawning another vehicle.");
				event.setCancelled(true);
			}
		}
	}
	public void orangeBoats(PlayerInteractEvent event){
		World world = Bukkit.getServer().getWorld("gWars");
		if(event.getClickedBlock().getLocation().equals(new Location(world, 837, 61, -37))){
			if(!Constants.vehiclehog.contains(event.getPlayer().getUniqueId())){
				world.spawnEntity(new Location(world, 833, 62, -36), EntityType.BOAT);
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Boat" + ChatColor.GRAY + ".");
				addPlayer(event.getPlayer());
				event.setCancelled(true);
			}
			else{
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Please wait " + ChatColor.AQUA + "30" + ChatColor.GRAY + " seconds before spawning another vehicle.");
				event.setCancelled(true);
			}
		}
		else if(event.getClickedBlock().getLocation().equals(new Location(world, 829, 61, -37))){
			if(!Constants.vehiclehog.contains(event.getPlayer().getUniqueId())){
				world.spawnEntity(new Location(world, 825, 62, -36), EntityType.BOAT);
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Boat" + ChatColor.GRAY + ".");
				addPlayer(event.getPlayer());
				event.setCancelled(true);
			}
			else{
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Please wait " + ChatColor.AQUA + "30" + ChatColor.GRAY + " seconds before spawning another vehicle.");
				event.setCancelled(true);
			}
		}
		else if(event.getClickedBlock().getLocation().equals(new Location(world, 821, 61, -37))){
			if(!Constants.vehiclehog.contains(event.getPlayer().getUniqueId())){
				world.spawnEntity(new Location(world, 817, 62, -36), EntityType.BOAT);
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Boat" + ChatColor.GRAY + ".");
				addPlayer(event.getPlayer());
				event.setCancelled(true);
			}
			else{
				event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Please wait " + ChatColor.AQUA + "30" + ChatColor.GRAY + " seconds before spawning another vehicle.");
				event.setCancelled(true);
			}
		}
	}
	public void addPlayer(Player p){
		Constants.vehiclehog.add(p.getUniqueId());
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				Constants.vehiclehog.remove(p.getUniqueId());
			}
		}, 600L);
	}
}
