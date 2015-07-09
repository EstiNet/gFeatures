package net.genesishub.gFeatures.Feature.gRanks.Commands;

import net.genesishub.gFeatures.Feature.gRanks.Retrieve;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TwoArg {
	Retrieve r = new Retrieve();
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		if(args[0].equalsIgnoreCase("get")){
			sender.sendMessage(ChatColor.GRAY + "------" + ChatColor.GOLD + "gRanks Help" + ChatColor.GRAY + "------");
			sender.sendMessage(ChatColor.GRAY + "/gRanks help - Shows the help page.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks get [Player] - Gets the rank of a player.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks set [Player] [Rank Name] - Sets the rank of a player.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks create [Rank Name] [Rank Prefix]");
			sender.sendMessage(ChatColor.GRAY + "/gRanks setprefix [Rank Name] [Rank Prefix]");
			sender.sendMessage(ChatColor.GRAY + "/gRanks delete [Rank Name]");
		}
		else{
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Please do /gRanks help.");
		}
	}
}
