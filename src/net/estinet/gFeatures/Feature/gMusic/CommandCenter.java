package net.estinet.gFeatures.Feature.gMusic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

public class CommandCenter {
	@SuppressWarnings("deprecation")
	public void CommandInitiate(final CommandSender sender, Command cmd, String label, String[] args) throws Exception{
		if(cmd.getName().equalsIgnoreCase("music") || cmd.getName().equalsIgnoreCase("play") || cmd.getName().equalsIgnoreCase("song") || cmd.getName().equalsIgnoreCase("gmusic")){
		if(!(sender instanceof Player)){
			Bukkit.getLogger().info("Players only!");
		}
		else{
			if(args.length == 0){
				sender.sendMessage(ChatColor.DARK_AQUA + "Opening music menu! :D");
				MusicMenu mm = new MusicMenu();
				mm.Initialize((Player) sender);
			}
			else if (args[0].equalsIgnoreCase("help")){
				sender.sendMessage("----Music Help----");
			}
			else if (args[0].equalsIgnoreCase("stop")){
				((Player) sender).playEffect(((Player) sender).getLocation(), Effect.RECORD_PLAY,
                        (short) 0);
                sender.sendMessage(ChatColor.RED + "Stopping any music.... (It's experimental and might not work).");
			}
			else{
				sender.sendMessage(ChatColor.AQUA + "/music");
			}
		}
	}
	}
}
