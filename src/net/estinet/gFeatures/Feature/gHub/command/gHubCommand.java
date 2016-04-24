package net.estinet.gFeatures.Feature.gHub.command;

import org.bukkit.ChatColor;

import net.estinet.gFeatures.Command.CommandExecutable;

public class gHubCommand extends CommandExecutable{
	@Override
	public void run() {
		if(super.args.length == 0){
			sender.sendMessage(ChatColor.GOLD + "[gHub]" + ChatColor.RESET + " " + ChatColor.BOLD + "Do /gHub help for help.");
		}
		else if(args.length == 1){
			switch(args[0].toLowerCase()){
			case "help":
				sender.sendMessage(ChatColor.STRIKETHROUGH + "----------" + ChatColor.RESET + "" + ChatColor.GOLD + "[gHub Help]" + ChatColor.RESET + "" + ChatColor.STRIKETHROUGH + "----------");
				sender.sendMessage(ChatColor.AQUA + "/gHub help : Displays the Help Menu.");
				sender.sendMessage(ChatColor.AQUA + "/gHub listcrystals : Lists the loaded crystals.");
				sender.sendMessage(ChatColor.AQUA + "/gHub deletecrystal [Name] : Deletes a crystal with given name.");
				sender.sendMessage(ChatColor.AQUA + "/gHub createcrystal [CategoryName] : Creates a crystal at your location with the given category name.");
				break;
			}
		}
	}
}
