package net.estinet.gFeatures.Feature.gHub.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Command.CommandExecutable;
import net.estinet.gFeatures.Feature.gHub.Basis;
import net.estinet.gFeatures.Feature.gHub.crystal.MGServer;

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
					sender.sendMessage(ChatColor.AQUA + "/gHub listcrystals : Lists the loaded crystals.");
					sender.sendMessage(ChatColor.AQUA + "/gHub deletecrystal [Name] : Deletes a crystal with given name.");
					sender.sendMessage(ChatColor.AQUA + "/gHub createcrystal [CategoryName] : Creates a crystal at your location with the given category name.");
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
						}
					}
					break;
				case "createcrystal":
					sender.sendMessage(ChatColor.GRAY + "Attempting to create crystal for " + args[1] + "...");
					break;
				}
			}
			else{
				sender.sendMessage(ChatColor.GOLD + "[gHub]" + ChatColor.RESET + " " + ChatColor.BOLD + "Do /gHub help for help.");
			}
		}
	}
}
