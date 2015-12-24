package net.genesishub.gFeatures.Feature.gHub.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			
		}
		else{
			sender.sendMessage(ChatColor.GRAY + "[gHub] Only players can use this command.");
		}
		return false;
	}
}
