package net.genesishub.gFeatures.Feature.GenesisBackup;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

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