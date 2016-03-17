package net.estinet.gFeatures.Feature.CTF;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

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

public class CommandHub{

	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		try{
		args[0].toLowerCase();
		}
		catch(Exception e){}
		if(args.length == 0){
			sender.sendMessage(ChatColor.AQUA + "Do /CTF help for help.");
		}
		else if(args.length == 1){
			switch(args[0]){
			case "help":
				sender.sendMessage(ChatColor.GOLD + "-----CTF Help-----");
				sender.sendMessage(ChatColor.AQUA + "/CTF help - Displays help for CTF.");
				sender.sendMessage(ChatColor.AQUA + "/CTF list - Lists all the teams and participants.");
				sender.sendMessage(ChatColor.AQUA + "/CTF mode - Gets the current state of the game.");
				sender.sendMessage(ChatColor.AQUA + "/CTF playermode [Player Name] - Gets the player state.");
				break;
			case "list":
				sender.sendMessage(ChatColor.GOLD + "Orange:");
				for(UUID uuid : Basic.teams.keySet()){
					if(Basic.teams.get(uuid).equals(Team.ORANGE)){
						String name = Bukkit.getPlayer(uuid).getName();
						sender.sendMessage(ChatColor.GRAY + "- " + name);
					}
				}
				sender.sendMessage(ChatColor.DARK_AQUA + "Blue:");
				for(UUID uuid : Basic.teams.keySet()){
					if(Basic.teams.get(uuid).equals(Team.BLUE)){
						String name = Bukkit.getPlayer(uuid).getName();
						sender.sendMessage(ChatColor.GRAY + "- " + name);
					}
				}
				break;
			case "mode":
				sender.sendMessage(ChatColor.AQUA + "The current game state is: " + Basic.mode.toString());
				break;
			default:
				sender.sendMessage(ChatColor.AQUA + "Do /CTF help for help.");
				break;
			}
		}
		else if(args.length == 2){
			switch(args[0]){
			case "playermode":
				if(Bukkit.getPlayer(args[1]) != null){
					sender.sendMessage(ChatColor.GRAY + Basic.modes.get(Bukkit.getPlayer(args[1]).getUniqueId()).toString());
				}
				else{
					sender.sendMessage(ChatColor.RED + "Player not found :/");
				}
				break;
			default:
				sender.sendMessage(ChatColor.AQUA + "Do /CTF help for help.");
				break;
			}
		}
		else{
			sender.sendMessage(ChatColor.AQUA + "Do /CTF help for help.");
		}
	}
}
