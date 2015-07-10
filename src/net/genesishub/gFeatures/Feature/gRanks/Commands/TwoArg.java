package net.genesishub.gFeatures.Feature.gRanks.Commands;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import net.genesishub.gFeatures.API.MojangAPI.UUIDFetcher;
import net.genesishub.gFeatures.Feature.gRanks.Basis;
import net.genesishub.gFeatures.Feature.gRanks.Rank;
import net.genesishub.gFeatures.Feature.gRanks.Retrieve;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TwoArg {
	Retrieve r = new Retrieve();
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		if(args[0].equalsIgnoreCase("get")){
			UUIDFetcher uuid = new UUIDFetcher(Arrays.asList(args[1]));
			Map<String, UUID> response = null;
			try {
				response = uuid.call();
			} catch (Exception e) {
				sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
				return;
			}
			String rs = r.getRank(response.get(args[1]).toString());
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Player " + args[1] + " is " + rs);
		}
		else if(args[0].equalsIgnoreCase("set")){
			if(!Basis.isRank(args[2])){
				sender.sendMessage(ChatColor.RED + "[gRanks] Are you sure that " + args[2] + " is a rank?");
			}
			else{
				UUIDFetcher uuid = new UUIDFetcher(Arrays.asList(args[1]));
				Map<String, UUID> response = null;
				try {
					response = uuid.call();
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
					return;
				}
				Rank rank = Basis.getRank(args[2]);
				r.setRank(rank, response.get(args[1]).toString());
				sender.sendMessage(ChatColor.GRAY + "[gRanks] Set " + args[1] + "'s rank to " + args[2]);
			}
		}
		else{
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Please do /gRanks help.");
		}
	}
}
