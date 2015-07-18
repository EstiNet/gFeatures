package net.genesishub.gFeatures.Feature.gRanks.Commands;

import net.genesishub.gFeatures.Feature.gRanks.Basis;
import net.genesishub.gFeatures.Feature.gRanks.Rank;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OneArg {
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		if(args[0].equalsIgnoreCase("help")){
			sender.sendMessage(ChatColor.GRAY + "------" + ChatColor.GOLD + "gRanks Help" + ChatColor.GRAY + "------");
			sender.sendMessage(ChatColor.GRAY + "/gRanks help - Shows the help page.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks get [Player] - Gets the rank of a player.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks set [Player] [Rank Name] - Sets the rank of a player.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks create [Rank Name] [Rank Prefix]");
			sender.sendMessage(ChatColor.GRAY + "/gRanks setprefix [Rank Name] [Rank Prefix]");
			sender.sendMessage(ChatColor.GRAY + "/gRanks delete [Rank Name]");
			sender.sendMessage(ChatColor.GRAY + "/gRanks list - Lists the ranks.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks perms [Rank Name] - Lists the ranks.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks refresh - Refreshes the plugin.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks inherits [Rank Name] - Lists which ranks the rank inherits.");
		}
		else if(args[0].equalsIgnoreCase("list")){
			sender.sendMessage(ChatColor.GRAY + "Ranks");
			for(Rank rank : Basis.getRanks()){
				sender.sendMessage(ChatColor.GRAY + "- " + rank.getName() + " with prefix of " + rank.getPrefix());
			}
		}
		else if(args[0].equalsIgnoreCase("refresh")){
			Basis b = new Basis();
			b.initializeQuery();
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Plugin refreshed.");
		}
		else{
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Please do /gRanks help.");
		}
	}
}
