package net.estinet.gFeatures.Feature.gRanks.Commands;

import net.estinet.gFeatures.Feature.gRanks.Basis;
import net.estinet.gFeatures.Feature.gRanks.Rank;
import net.estinet.gFeatures.Feature.gRanks.Global.FileSync;
import net.estinet.gFeatures.Feature.gRanks.Global.InheritSync;
import net.estinet.gFeatures.Feature.gRanks.Perms.Cleanup;

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
			sender.sendMessage(ChatColor.GRAY + "/gRanks push - Pushes all local changes to Global nodes.");
			sender.sendMessage(ChatColor.GRAY + "/gRanks cleanup - Cleansup the plugin files.");
		}
		else if(args[0].equalsIgnoreCase("list")){
			sender.sendMessage(ChatColor.GRAY + "Ranks");
			for(Rank rank : Basis.getRanks()){
				sender.sendMessage(ChatColor.GRAY + "- " + rank.getName() + " with prefix of " + rank.getPrefix());
			}
		}
		else if(args[0].equalsIgnoreCase("refresh")){
			Thread thr = new Thread(new Runnable(){
				public void run(){
					Basis b = new Basis();
					b.initializeQuery();
				}
			});
			thr.start();
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Plugin refreshed.");
		}
		else if(args[0].equalsIgnoreCase("push")){
			FileSync fs = new FileSync();
			fs.push();
			InheritSync is = new InheritSync();
			is.push();
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Your changes have been pushed.");
		}
		else if(args[0].equalsIgnoreCase("cleanup")){
			Thread th = new Thread(new Cleanup());
    		th.start();
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Cleanup has started.");
		}
		else{
			sender.sendMessage(ChatColor.GRAY + "[gRanks] Please do /gRanks help.");
		}
	}
}
