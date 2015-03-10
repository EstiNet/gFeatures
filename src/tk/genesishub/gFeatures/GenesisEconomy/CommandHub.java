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
        	  sender.sendMessage("You have " + mm.getMoney(player));
          }
          if(args.length == 1){
        	  switch(args[0]){
        	  case "help":
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"-----Help-----");
        		  sender.sendMessage(ChatColor.AQUA + "/clupic | Views how much clupic you have.");
        		  sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD +"-----Help-----");
        	  }
          }
        }
	}
}
