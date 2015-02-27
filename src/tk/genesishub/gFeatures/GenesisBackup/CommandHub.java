package tk.genesishub.gFeatures.GenesisBackup;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHub {
	public void CommandInitiate(final CommandSender sender, Command cmd, String label, String[] args){
		if(args.length == 0){
			sender.sendMessage(ChatColor.GRAY + "Please do /GenesisBackup help");
		}
		else if(args.length == 1){
			
		}
	}
}
