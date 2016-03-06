package net.estinet.gFeatures.Feature.gFactions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

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

public class Camera {
	public void Tutorial(final Player p){
		p.hidePlayer(p);
		for(World world : Bukkit.getServer().getWorlds()){
			Bukkit.getLogger().info(world.getName());
		}
		World world = Bukkit.getServer().getWorld("Factions1.8.3");
		final Location loc = new Location(world, -130.6, 67, 14.3, 20.9F, 50.1F);
		final Location loc1 = new Location(world, -58.5, 105.3, 35.2, 47.3F, 218.7F);
		final Location loc2 = new Location(world, -120.7, 89.4, -20.5, 39.5F, 33.6F);
		final Location loc3 = new Location(world, -148, 72.9, 5.8, 7.2F, 89.1F);
		/*Location loc = new Location(world, 44.3, 206, -167, 10.8F, -317.2F);
		loc.setPitch(-317.2F);
		loc.setYaw(10.8F);
		final Location loc1 = new Location(world,36.6,223.2,-129.5, 32.0F, -297.3F);
		loc.setPitch(-297.3F);
		loc.setYaw(32.0F);
		final Location loc2 = new Location(world,44,230.3,-110.8, 33.8F, -252.1F);
		loc.setPitch(-252.1F);
		loc.setYaw(33.8F);
		final Location loc3 = new Location(world,-1.8,230.3,-89.7, 30.2F, -85.8F);
		loc.setPitch(-85.8F);
		loc.setYaw(30.2F);
		final Location loc4 = new Location(world,8.4,230.3,-71.5, 39.2F, -19F);
		loc.setPitch(-19F);
		loc.setYaw(39.2F);
		final Location loc5 = new Location(world,-2.3,225,-60.3, 61.8F, -304.2F);
		loc.setPitch(-304.2F);
		loc.setYaw(61.8F);
		final Location loc6 = new Location(world,-37.4,216,-36.6, 61.8F, -304.2F);
		loc.setPitch(-304.2F);
		loc.setYaw(61.8F);
		final Location loc7 = new Location(world,-62.8,201.0,-19.7, 79.3F, -304.0F);
		loc.setPitch(-304.0F);
		loc.setYaw(79.3F);
		final Location loc8 = new Location(world,-83.3,174.1,-4.1, 56.9F, -299.5F);
		loc.setPitch(-299.5F);
		loc.setYaw(56.9F);
		final Location loc9 = new Location(world,-102,131,10.7, 60.6F, -300.7F);
		loc.setPitch(-300.7F);
		loc.setYaw(60.6F);
		final Location loc10 = new Location(world,-108.5,104,14.5, 41.7F, -301.6F);
		loc.setPitch(-301.6F);
		loc.setYaw(41.7F);
		final Location loc11 = new Location(world,-121.3,73.6,21.3, 12.3F, -291.1F);
		loc.setPitch(-291.1F);
		loc.setYaw(12.3F);
		final Location loc12 = new Location(world,-121.4,73.6,21.4, 9.6F, -22.3F);
		loc.setPitch(-22.3F);
		loc.setYaw(9.6F);
		final Location loc13 = new Location(world,-116.3,73.6,31.9, 32.7F, -64.5F);
		loc.setPitch(-64.5F);
		loc.setYaw(32.7F);
		final Location loc14 = new Location(world,-100.1,66.1,39.7, 15.6F,-190.2F);
		loc.setPitch(-190.2F);
		loc.setYaw(15.6F);
		final Location loc15 = new Location(world,-101.2,66,37.9,-12.1F,-239.8F);
		loc.setPitch(-239.8F);
		loc.setYaw(-12.1F);*/
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add camerastudio");
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		p.sendMessage(ChatColor.DARK_AQUA + "Welcome to EstiNet " + ChatColor.RED + "Factions" + ChatColor.DARK_AQUA + "!");
		p.sendMessage(ChatColor.DARK_AQUA + "Before we begin, we are going to setup the tutorial. This may take up to 20 seconds.!");
		p.sendMessage(ChatColor.DARK_AQUA + "During this time you will be teleported and you will be executing some commands!");
		//SETUP
		p.teleport(loc);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc1);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc2);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
		p.teleport(loc3);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam p");
        		}
			}, 20L);
	        	}
			}, 20L);
	        	}
			}, 20L);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " cam start 30s");
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		p.sendMessage(ChatColor.DARK_AQUA + "Done! Let's get started!");
		p.sendMessage(ChatColor.DARK_AQUA + "Now, this is our spawn.");
		p.sendMessage(ChatColor.DARK_AQUA + "We'll be hovering here for a while.");
		p.sendMessage(ChatColor.DARK_AQUA + "Sit back and enjoy the ride!");
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		p.showPlayer(p);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " remove camerastudio");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {

			@Override
			public void run() {
				nextPlayer(p);
			}
			
    		}, 650L);
        	}
		}, 70L);
	}
	public void nextPlayer(final Player p){
		final World world = Bukkit.getServer().getWorld("Factions1.8.3");
		Location locs = new Location(world, 31, 207, -118, 21.75F, 179.228F);
		p.teleport(locs);
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		p.sendMessage(ChatColor.DARK_AQUA + "This is where you first spawn!");
		p.sendMessage(ChatColor.DARK_AQUA + "Nothing much here. -_-");
		p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {

			@Override
			public void run() {
				Location locs = new Location(world, -117, 65, 45, 36.728F, -9.3F);
				p.teleport(locs);
				p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
				p.sendMessage(ChatColor.DARK_AQUA + "This is our fishing shack!");
				p.sendMessage(ChatColor.DARK_AQUA + "Hike down the mountain or do /warp Fishing to get here!");
				p.sendMessage(ChatColor.DARK_AQUA + "There are also animals around here.");
				p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {

					@Override
					public void run() {
						Location locs = new Location(world, 41, 206, -127, 90.278F, 0.15F);
						p.teleport(locs);
						p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
						p.sendMessage(ChatColor.DARK_AQUA + "This is our shop!");
						p.sendMessage(ChatColor.DARK_AQUA + "You can buy guns, obsidian, and any other necessities here!");
						p.sendMessage(ChatColor.DARK_AQUA + "You can also do /buy.");
						p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {

							@Override
							public void run() {
								Location locs = new Location(world, -9, 216, -162, 299.228F, 40.5F);
								p.teleport(locs);
								p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
								p.sendMessage(ChatColor.DARK_AQUA + "This is our dock!");
								p.sendMessage(ChatColor.DARK_AQUA + "Summon a boat and travel to the wilderness!");
								p.sendMessage(ChatColor.DARK_AQUA + "Do /warp Boat to get here.");
								p.sendMessage(ChatColor.DARK_AQUA + "That's the end of the quick tutorial. Thanks!");
								p.sendMessage(ChatColor.AQUA + "____" + ChatColor.GOLD + "Tutorial" + ChatColor.AQUA + "____");
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {

									@Override
									public void run() {
										Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " spawn");
									}
									
						    		}, 160L);
							}
							
				    		}, 160L);
					}
					
		    		}, 175L);
			}
			
    		}, 170L);
	}
}
