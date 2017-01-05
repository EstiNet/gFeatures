package net.estinet.gFeatures.Feature.SurvivalTwo.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Command.CommandExecutable;
import net.estinet.gFeatures.Feature.SurvivalTwo.Menus.Shop;

public class TradeCommand extends CommandExecutable{
	@Override
	public void run() {
		if(super.args.length == 1){
			
		}
		else{
			sender.sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "/trade [player]!");
		}
	}
}
