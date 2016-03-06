package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEvent;

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

public class Interact {
	public void initialize(PlayerInteractEvent event){
		try{
		World world = Bukkit.getServer().getWorld("gWars");
		if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getServer().getWorld("gWars"), 657, 61, -56))){//Orange
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
			event.setCancelled(true);
		}
		else if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getServer().getWorld("gWars"), 24, 61, 216))){//Blue
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
			event.setCancelled(true);
		}
		}catch(Exception e){
		}
	}
}
