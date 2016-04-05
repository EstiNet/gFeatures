package net.estinet.gFeatures.Feature.gRanks.Commands;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import net.estinet.gFeatures.API.MojangAPI.UUIDFetcher;
import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;
import net.estinet.gFeatures.Feature.gRanks.Retrieve;

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

public class ThreeArg {
	Retrieve r = new Retrieve();
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		if(args[0].equalsIgnoreCase("set")){
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
				sender.sendMessage(ChatColor.GRAY + "[gRanks] Set " + args[1] + "'s rank to " + args[2] + ".");
			}
		}
		else if(args[0].equalsIgnoreCase("create")){
			Rank newrank = new Rank(args[1], args[2]);
			r.addRank(newrank);
			String name = newrank.getName().replace('&', '§');
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Created rank " + args[1] + "" + ChatColor.RESET + ""  + ChatColor.GRAY + " with the prefix of " + name + "" + ChatColor.RESET + "" + ChatColor.GRAY + ".");
		}
		else{
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Please do /gRanks help.");
		}
	}
}
