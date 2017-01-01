package net.estinet.gFeatures.Feature.gHub.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Command.CommandExecutable;
import net.estinet.gFeatures.Feature.gHub.Basis;
import net.estinet.gFeatures.Feature.gHub.gHub;
import net.estinet.gFeatures.Feature.gHub.crystal.MGServer;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class gHubCommand extends CommandExecutable{
	@Override
	public void run() {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.BOLD + "Consoles can't do this!");
		}
		else{
			if(super.args.length == 0){
				sender.sendMessage(ChatColor.GOLD + "[gHub]" + ChatColor.RESET + " " + ChatColor.BOLD + "Do /gHub help for help.");
			}
			else if(args.length == 1){
				switch(args[0].toLowerCase()){
				case "help":
					sender.sendMessage(ChatColor.STRIKETHROUGH + "----------" + ChatColor.RESET + "" + ChatColor.GOLD + "[gHub Help]" + ChatColor.RESET + "" + ChatColor.STRIKETHROUGH + "----------");
					sender.sendMessage(ChatColor.AQUA + "/gHub help : Displays the Help Menu.");
					sender.sendMessage(ChatColor.AQUA + "/gHub setspawn : Sets the server spawn.");
					sender.sendMessage(ChatColor.AQUA + "/gHub togglefall : Toggles fall protection.");
					sender.sendMessage(ChatColor.AQUA + "/gHub listcrystals : Lists the loaded crystals.");
					sender.sendMessage(ChatColor.AQUA + "/gHub deletecrystal [Name] : Deletes a crystal with given name.");
					sender.sendMessage(ChatColor.AQUA + "/gHub createcrystal [CategoryName] : Creates a crystal at your location with the given category name.");
					break;
				case "setspawn":
					try{
						sender.sendMessage(ChatColor.GRAY + "Setting server spawn to your location.");
						Basis.setSpawn(((Player)sender).getLocation());
					}
					catch(Exception e){
						sender.sendMessage(ChatColor.GRAY + "You aren't a player!");
					}
					break;
				case "togglefall":
					if(gHub.fall){
						gHub.fall = false;
						sender.sendMessage(ChatColor.GRAY + "Turning off fall protection.");
					}
					else{
						gHub.fall = true;
						sender.sendMessage(ChatColor.GRAY + "Turning on fall protection.");
					}
					break;
				case "listcrystals":
					sender.sendMessage(ChatColor.STRIKETHROUGH + "----------" + ChatColor.RESET + "" + ChatColor.GOLD + "Crystals" + ChatColor.RESET + "" + ChatColor.STRIKETHROUGH + "----------");
					for(MGServer mgs : Basis.crystals.values()){
						sender.sendMessage(ChatColor.GRAY + "- " + mgs.getName());
					}
					break;
				default:
					sender.sendMessage(ChatColor.GOLD + "[gHub]" + ChatColor.RESET + " " + ChatColor.BOLD + "Do /gHub help for help.");
					break;
				}
			}
			else if(args.length == 2){
				switch(args[0].toLowerCase()){
				case "deletecrystal":
					sender.sendMessage(ChatColor.GRAY + "Attempting to delete " + args[1] + "...");
					for(MGServer mgs : Basis.crystals.values()){
						if(mgs.getName().equalsIgnoreCase(args[1])){
							Basis.crystals.remove(mgs.getLocation());
							File file = new File("plugins/gFeatures/gHub/Crystals/" + args[1] + ".txt");
							file.delete();
							for(Entity entity : Bukkit.getWorld("EstiNet").getEntities()){
								if(entity.getType().equals(EntityType.ENDER_CRYSTAL) && entity.getLocation().equals(mgs.getLocation())){
									entity.remove();
								}
							}
						}
					}
					break;
				case "createcrystal":
					sender.sendMessage(ChatColor.GRAY + "Attempting to create crystal for " + args[1] + "...");
					Player p = (Player) sender;
					MGServer mgs = new MGServer(args[1], new Location(Bukkit.getWorld("EstiNet"), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ()));
					Basis.crystals.put(mgs.getLocation(), mgs);
					File file = new File("plugins/gFeatures/gHub/Crystals/" + args[1] + ".txt");
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					PrintWriter writer;
					try {
						writer = new PrintWriter(file, "UTF-8");
						writer.println(args[1]);
						writer.println(p.getLocation().getX());
						writer.println(p.getLocation().getY());
						writer.println(p.getLocation().getZ());
						writer.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					Bukkit.getWorld("EstiNet").spawn(mgs.getLocation(), EnderCrystal.class);
					break;
				}
			}
			else{
				sender.sendMessage(ChatColor.GOLD + "[gHub]" + ChatColor.RESET + " " + ChatColor.BOLD + "Do /gHub help for help.");
			}
		}
	}
}
