package net.estinet.gFeatures.Feature.GenesisBackup;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

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

public class CommandHub {
	public void CommandInitiate(final CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("GenesisBackup") || cmd.getName().equalsIgnoreCase("gBackup") || cmd.getName().equalsIgnoreCase("gb")){
		if(args.length == 0){
			sender.sendMessage(ChatColor.GRAY + "Please do /gBackup help.");
			}
		else if(args.length == 1){
				switch(args[1]){
				case "help":
					sender.sendMessage(ChatColor.GRAY + "-----Help-----");
					sender.sendMessage(ChatColor.GRAY + "/gBackup help - Displays the help page.");
					sender.sendMessage(ChatColor.GRAY + "/gBackup backup <preset> - Backups the preset.");
					sender.sendMessage(ChatColor.GRAY + "/gBackup timer <time in hours> <preset> - Sets the timer for the preset.");
					break;
				}
			}
		}
	}
}