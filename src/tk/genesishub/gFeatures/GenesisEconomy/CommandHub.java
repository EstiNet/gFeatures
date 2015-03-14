package tk.genesishub.gFeatures.GenesisEconomy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub {
	MoneyManager mm = new MoneyManager();
	public void Intitiate(CommandSender sender, Command command, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
            Bukkit.getLogger().info("Only players are supported for this GenesisEconomy as of now.");
        }
        Player player = (Player) sender;
        if(command.getLabel().equals("clupic")) {
          if(args.length == 0){
        	  float m = mm.getMoney(player);
        	  if(m%0.1 == 0){
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You have " + ChatColor.AQUA + "" + mm.getMoney(player) + "0" + ChatColor.GOLD + "" + ChatColor.BOLD + " clupic.");
        	  }
        	  else{
        	  sender.sendMessage("You have " + mm.getMoney(player));
        	  }
          }
          if(args.length == 1){
        	  switch(args[0]){
        	  case "help":
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"-----Help-----");
        		  sender.sendMessage(ChatColor.AQUA + "/clupic | Views how much clupic you have.");
        		  sender.sendMessage(ChatColor.AQUA + "/clupic pay <player> <amount>| Pays a player.");
        		  sender.sendMessage(ChatColor.AQUA + "/clupic set <player> <amount>| Admin command.");
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"-----Help-----");
        		  break;
        	  case "pay":
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Usage: /clupic pay <player> <amount>");
        		  break;
        	  case "set":
        		  if(sender.hasPermission("GenesisEconomy.admin")){
        			  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Usage: /clupic set <player> <amount>");
        		  }
        	  }
          }
        }
	}
}
