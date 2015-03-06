package tk.genesishub.gFeatures.GenesisEconomy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub {
	public void Intitiate(CommandSender sender, Command command, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
            Bukkit.getLogger().info("Only players are supported for this GenesisEconomy as of now.");
        }
        Player player = (Player) sender;
        if(command.getLabel().equals("clupic")) {
          if(args.length == 0){
        	  
          }
        } 
	}
}
