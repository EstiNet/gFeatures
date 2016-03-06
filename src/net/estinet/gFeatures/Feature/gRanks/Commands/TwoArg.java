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
			String rs;
			try{
			rs = r.getRank(response.get(args[1]).toString());
			}
			catch(Exception e){
				sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
				return;
			}
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Player " + args[1] + " is " + rs);
		}
		else if(args[0].equalsIgnoreCase("delete")){
			Rank newrank = new Rank(args[1], "");
			r.deleteRank(newrank);
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Deleted rank " + args[1] + ".");
		}
		else if(args[0].equalsIgnoreCase("perms")){
			try{
			Rank rank = Basis.getRank(args[1]);
			sender.sendMessage(ChatColor.GRAY + "Permissions for " + args[1]);
			for(String perm : rank.getPerms()){
				sender.sendMessage(ChatColor.GRAY + "- " + perm);
			}
			}
			catch(Exception e){
				sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
				return;
			}
			
		}
		else if(args[0].equalsIgnoreCase("inherits")){
			try{
				Rank ra = Basis.getRank(args[1]);
				sender.sendMessage(ChatColor.GRAY + "Inherited Ranks:");
				for(Rank inherit : ra.getInheritList()){
					sender.sendMessage(ChatColor.GRAY + "- " + inherit.getName());
				}
			}
			catch(Exception e){
				sender.sendMessage(ChatColor.RED + "[gRanks] Error with your input. Please try again!");
				return;
			}
		}
		else{
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Please do /gRanks help.");
		}
	}
}
