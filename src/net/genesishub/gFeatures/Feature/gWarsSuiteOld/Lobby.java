package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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

public class Lobby {
	Constants cons = new Constants();
	public void LobbyInitiate(final CommandSender sender, Command cmd, String label, String[] args, String value){
		Player player = (Player)sender;
		World world = Bukkit.getServer().getWorld("gWars");
		switch(value){
		case "airfield": 
			Initiate(421, 5, 201, 89.998, 1.95, 575, 1, 131, 269.849, -0.3, (Player)sender, sender);
			break;
		case "underground": 
			Initiate(422, 2, 225, 89.545, 6.45, 569, 2, 107, 271.795, -12.45, (Player)sender, sender);
			break;
		case "mainfloor": 
			Initiate(433, 5, 225, 89.545, 6.45, 557, 5, 107, 271.795, -12.45, (Player)sender, sender);
			break;
		case "turrets": 
			Initiate(426, 15, 225, 89.545, 6.45, 555, 15, 107, 89.545, -6.45, (Player)sender, sender);
			break;
		case "spawn": 
			Initiate(134, 11, 277, 89.545, 6.45, 134, 53, 282, 89.545, -6.45, (Player)sender, sender, "THIS IS A STRING");
			break;
		case "town": 
			ItemStack chest = new ItemStack(Material.CHEST, 1);
            ItemMeta im = chest.getItemMeta();
            im.setDisplayName(ChatColor.AQUA + "Game Menu");
            chest.setItemMeta(im);
			if(Constants.arena.contains(player.getName())){
	    		sender.sendMessage("You are in the arena!");
	    		}
	    		else{
	    		if(Constants.ot.contains(player.getName())){
	    		Block block = world.getBlockAt(223, 3, 168);
	    		if(block.getType() == Material.GRASS){
	    		Constants.arena.add(player.getName());
	    		double x1 = 496;
	    		double y1 = 5;
	    		double z1 = 175;
	    		Location e = new Location(player.getWorld(), x1, y1, z1);
	    		player.teleport(e);
	    		player.getLocation().setYaw((float) 178.803);
	    		player.getLocation().setPitch((float) -1.8);
	    		player.getInventory().addItem(chest);
	    		ItemStack compass = new ItemStack(Material.COMPASS, 1);
	            ItemMeta im1 = compass.getItemMeta();
	            im1.setDisplayName(ChatColor.GOLD + "Player Finder");
	            compass.setItemMeta(im1);
	            player.getInventory().addItem(compass);
	    		}
	    		else{
	    			sender.sendMessage("Your team didn't capture the town yet!");
	    		}
	    		}
	    		else if(Constants.bt.contains(player.getName())){
	    		Block block = world.getBlockAt(223, 3, 168);
	    		if(block.getType() == Material.STONE){
	    		Constants.arena.add(player.getName());
	    		double x1 = 496;
	        	double y1 = 5;
	        	double z1 = 175;
	        	Location e = new Location(player.getWorld(), x1, y1, z1);
	        	player.teleport(e);
	        	player.getLocation().setYaw((float) 178.803);
	        	player.getLocation().setPitch((float) -1.8);
	        	player.getInventory().addItem(chest);
	        	ItemStack compass = new ItemStack(Material.COMPASS, 1);
	            ItemMeta im1 = compass.getItemMeta();
	            im1.setDisplayName(ChatColor.GOLD + "Player Finder");
	            compass.setItemMeta(im1);
	            player.getInventory().addItem(compass);
	    		}
	    		else{
	    		sender.sendMessage("Your team didn't capture the town yet!");
	    		}
	    		}
	    		}
			break;
		case "island":
			if(Constants.arena.contains(player.getName())){
	    		sender.sendMessage("You are in the arena!");
	    		}
	    		else{
	    		if(Constants.ot.contains(player.getName())){
	    		Block block = world.getBlockAt(223, 3, 169);
	    		if(block.getType() == Material.GRASS){
	    		Constants.arena.add(player.getName());
	    		double x1 = 551;
	    		double y1 = 5;
	    		double z1 = 420;
	    		Location e = new Location(player.getWorld(), x1, y1, z1);
	    		player.teleport(e);
	    		player.getLocation().setYaw((float) 179.999);
	    		player.getLocation().setPitch((float) -2.1);
	    		ItemStack chest1 = new ItemStack(Material.CHEST, 1);
	            ItemMeta im1 = chest1.getItemMeta();
	            im1.setDisplayName(ChatColor.AQUA + "Game Menu");
	            chest1.setItemMeta(im1);
	    		player.getInventory().addItem(chest1);
	    		ItemStack compass = new ItemStack(Material.COMPASS, 1);
	            ItemMeta im2 = compass.getItemMeta();
	            im2.setDisplayName(ChatColor.GOLD + "Player Finder");
	            compass.setItemMeta(im2);
	            player.getInventory().addItem(compass);
	    		}
	    		else{
	    			sender.sendMessage("Your team didn't capture the island yet!");
	    		}
	    		}
	    		else if(Constants.bt.contains(player.getName())){
	    		Block block = world.getBlockAt(223, 3, 169);
	    		if(block.getType() == Material.STONE){
	    		Constants.arena.add(player.getName());
	    		double x1 = 551;
	        	double y1 = 5;
	        	double z1 = 420;
	        	Location e = new Location(player.getWorld(), x1, y1, z1);
	        	player.teleport(e);
	        	player.getLocation().setYaw((float) 179.999);
	        	player.getLocation().setPitch((float) -2.1);
	        	ItemStack chest2 = new ItemStack(Material.CHEST, 1);
	            ItemMeta im2 = chest2.getItemMeta();
	            im2.setDisplayName(ChatColor.AQUA + "Select Gun");
	            chest2.setItemMeta(im2);
	        	player.getInventory().addItem(chest2);
	        	ItemStack compass = new ItemStack(Material.COMPASS, 1);
	            ItemMeta im1 = compass.getItemMeta();
	            im1.setDisplayName(ChatColor.GOLD + "Player Finder");
	            compass.setItemMeta(im1);
	            player.getInventory().addItem(compass);
	    		}
	    		else{
	    		sender.sendMessage("Your team didn't capture the island yet!");
	    		}
	    		}
	    		}
			break;
		}
	}
	public void Initiate(int ox, int oy, int oz, double oyaw, double opitch, int bx, int by, int bz, double byaw, double bpitch, Player player, CommandSender sender){
		ItemStack chest = new ItemStack(Material.CHEST, 1);
        ItemMeta im = chest.getItemMeta();
        im.setDisplayName(ChatColor.AQUA + "Game Menu");
        chest.setItemMeta(im);
		if(Constants.arena.contains(player.getName())){
    		sender.sendMessage("You are in the arena!");
    		}
    		else{
    		if(Constants.ot.contains(player.getName())){
    		Constants.arena.add(player.getName());
    		double x1 = ox;
    		double y1 = oy;
    		double z1 = oz;
    		Location e = new Location(player.getWorld(), x1, y1, z1);
    		player.teleport(e);
    		player.getLocation().setYaw((float) oyaw);
    		player.getLocation().setPitch((float) opitch);
    		player.getInventory().addItem(chest);
    		ItemStack compass = new ItemStack(Material.COMPASS, 1);
            ItemMeta im1 = compass.getItemMeta();
            im1.setDisplayName(ChatColor.GOLD + "Player Finder");
            compass.setItemMeta(im1);
            player.getInventory().addItem(compass);
    		}
    		else if(Constants.bt.contains(player.getName())){
    		Constants.arena.add(player.getName());
    		double x1 = bx;
        	double y1 = by;
        	double z1 = bz;
        	Location e = new Location(player.getWorld(), x1, y1, z1);
        	player.teleport(e);
        	player.getLocation().setYaw((float) byaw);
        	player.getLocation().setPitch((float) bpitch);
        	player.getInventory().addItem(chest);
        	ItemStack compass = new ItemStack(Material.COMPASS, 1);
            ItemMeta im1 = compass.getItemMeta();
            im1.setDisplayName(ChatColor.GOLD + "Player Finder");
            compass.setItemMeta(im1);
            player.getInventory().addItem(compass);
    		}
    	}
	}
	// IF NO ARENA ADD
	public void Initiate(int ox, int oy, int oz, double oyaw, double opitch, int bx, int by, int bz, double byaw, double bpitch, Player player, CommandSender sender, String nothing){
		if(Constants.arena.contains(player.getName())){
    		sender.sendMessage("You are in the arena!");
    		}
    		else{
    		if(Constants.ot.contains(player.getName())){
    		double x1 = ox;
    		double y1 = oy;
    		double z1 = oz;
    		Location e = new Location(player.getWorld(), x1, y1, z1);
    		player.teleport(e);
    		player.getLocation().setYaw((float) oyaw);
    		player.getLocation().setPitch((float) opitch);
    		}
    		else if(Constants.bt.contains(player.getName())){
    		double x1 = bx;
        	double y1 = by;
        	double z1 = bz;
        	Location e = new Location(player.getWorld(), x1, y1, z1);
        	player.teleport(e);
        	player.getLocation().setYaw((float) byaw);
        	player.getLocation().setPitch((float) bpitch);
    		}
    	}
	}
}
