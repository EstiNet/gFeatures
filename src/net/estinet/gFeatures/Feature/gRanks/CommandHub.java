package net.estinet.gFeatures.Feature.gRanks;

import net.estinet.gFeatures.Feature.gRanks.Commands.OneArg;
import net.estinet.gFeatures.Feature.gRanks.Commands.ThreeArg;
import net.estinet.gFeatures.Feature.gRanks.Commands.TwoArg;

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

public class CommandHub{
	OneArg oa = new OneArg();
	TwoArg ta = new TwoArg();
	ThreeArg tha = new ThreeArg();
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("gRanks")){
			if(args.length == 1){
				oa.onCommand(sender, cmd, label, args);
			}
			else if(args.length == 2){
				ta.onCommand(sender, cmd, label, args);
			}
			else if(args.length == 3){
				tha.onCommand(sender, cmd, label, args);
			}
			else{
				sender.sendMessage(ChatColor.GRAY + "[gRanks] Do /gRanks help.");
			}
		}
	}
}
