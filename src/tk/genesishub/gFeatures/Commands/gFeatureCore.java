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
					
					break;
				}
			}
		}
		return null;
	}
}
