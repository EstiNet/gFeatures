package tk.genesishub.gFeatures.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class gFeatureCore {
	public String CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("gf") || cmd.getName().equalsIgnoreCase("gFeature") || cmd.getName().equalsIgnoreCase("gFeatures")){
			if(args.length == 0){
				sender.sendMessage(ChatColor.GRAY + "Please do /gFeatures help.");
			}
			else if(args.length == 1){
				switch(args[0]){
				case "version":
					sender.sendMessage(ChatColor.GRAY + "gFeatures Version 1.0.0");
					break;
				case "help":
					sender.sendMessage(ChatColor.GRAY + "------Help------");
					sender.sendMessage(ChatColor.GRAY + "/gFeatures version : States the plugin version.");
					sender.sendMessage(ChatColor.GRAY + "/gFeatures list : Lists all plugins with their states also.");
					break;
				case "list":
					if()
				}
			}
		}
		return null;
	}
}
