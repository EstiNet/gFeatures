package net.genesishub.gFeatures;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CoreCommands extends CommandLibrary{
	@Override
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		try {
			if(Check("Base", cmd.getName())){
				if(cmd.getName().equalsIgnoreCase("test")){
					Bukkit.getLogger().info("Test!");
				}
			}
			else{
				Bukkit.getLogger().info("GenesisHub has never heard of this command. Do /help for help.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
