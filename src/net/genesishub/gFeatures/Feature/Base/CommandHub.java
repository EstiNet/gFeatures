package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.genesishub.gFeatures.CommandLibrary;

public class CommandHub{
	
	CommandLibrary cl = new CommandLibrary();
	
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		try {
			if(cl.Check("Base", cmd.getName())){
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
