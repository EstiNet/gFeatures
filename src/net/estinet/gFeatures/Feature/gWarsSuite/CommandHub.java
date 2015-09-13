package net.estinet.gFeatures.Feature.gWarsSuite;

import net.estinet.gFeatures.Basic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

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

public class CommandHub {
	Statistics stats = new Statistics();
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("gWars")){
			if(args.length == 0){
				sender.sendMessage(ChatColor.GRAY + "Do /gWars help.");
			}
			else if(args.length == 1){
				if(args[0].equalsIgnoreCase("help")){
					sender.sendMessage(ChatColor.GRAY + "[x] [x] Help [x] [x]");
					sender.sendMessage(ChatColor.AQUA + "/gWars stats [Player] - Shows your stats or another player.");
					sender.sendMessage(ChatColor.AQUA + "/gWars kills [amount] [Player] - Sets a player's kills stat.");
					sender.sendMessage(ChatColor.AQUA + "/gWars deaths [amount] [Player] - Sets a player's deaths stat.");
					sender.sendMessage(ChatColor.AQUA + "/gWars mode [value] [Player] - Sets a player's mode stat.");
					sender.sendMessage(ChatColor.AQUA + "/gWars version - Shows the version. ");
				}
				else if(args[0].equalsIgnoreCase("stats")){
					sender.sendMessage(ChatColor.GRAY + "[x] [x] Stats [x] [x]");
					sender.sendMessage(ChatColor.AQUA + "Kills: " + stats.getKills((Player)sender));
					sender.sendMessage(ChatColor.AQUA + "Deaths: " + stats.getDeaths((Player)sender));
					sender.sendMessage(ChatColor.AQUA + "Mode: " + stats.getMode((Player)sender));
				}
				else if(args[0].equalsIgnoreCase("version")){
					sender.sendMessage(ChatColor.GRAY + "gWarsSuite version " + Basic.getFeature("gWarsSuite").getVersion());
				}
				else{
					sender.sendMessage(ChatColor.AQUA + "Do /gWars help.");
				}
			}
			else if(args.length == 2){
				if(args[0].equalsIgnoreCase("stats")){
					for(Player p : Bukkit.getOnlinePlayers()){
						if(p.getName().equalsIgnoreCase(args[1])){
							sender.sendMessage(ChatColor.GRAY + "[x] [x] Stats [x] [x]");
							sender.sendMessage(ChatColor.AQUA + "Kills: " + stats.getKills(p));
							sender.sendMessage(ChatColor.AQUA + "Deaths: " + stats.getDeaths(p));
							sender.sendMessage(ChatColor.AQUA + "Mode: " + stats.getMode(p));
						}
					}
					try{
						for(OfflinePlayer p : Bukkit.getOfflinePlayers()){
							if(p.getName().equalsIgnoreCase(args[1])){
								sender.sendMessage(ChatColor.GRAY + "[x] [x] Stats [x] [x]");
								sender.sendMessage(ChatColor.AQUA + "Kills: " + stats.getKills((Player)p));
								sender.sendMessage(ChatColor.AQUA + "Deaths: " + stats.getDeaths((Player)p));
								sender.sendMessage(ChatColor.AQUA + "Mode: " + stats.getMode((Player)p));
							}
						}
					}
					catch(Exception e){
						sender.sendMessage(ChatColor.RED + "An error occured with your input.");
					}
				}
				else{
					sender.sendMessage(ChatColor.AQUA + "Do /gWars help.");
				}
			}
			else if(args.length == 3){
				if(args[0].equalsIgnoreCase("mode")){
					for(Player p : Bukkit.getOnlinePlayers()){
						if(p.getName().equalsIgnoreCase(args[2])){
							for(gWarsMode modes : gWarsMode.values()){
								if(modes.toString().equals(args[1])){
									stats.setMode(p, modes);
									sender.sendMessage(ChatColor.AQUA + "Set " + args[2] + "'s mode to " + args[1]);
									return;
								}
							}
						}
					}
						sender.sendMessage(ChatColor.RED + "An error occured with your input.");
				}
				else{
					sender.sendMessage(ChatColor.AQUA + "Do /gWars help.");
				}
			}
			else{
				sender.sendMessage(ChatColor.AQUA + "Do /gWars help.");
			}
		}
	}
}
