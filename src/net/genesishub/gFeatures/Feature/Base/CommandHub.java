package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.genesishub.gFeatures.CommandLibrary;

public class CommandHub extends CommandLibrary{
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		try {
			if(Check("Base", cmd.getName())){
				if(cmd.getName().equalsIgnoreCase("test")){
					Bukkit.getLogger().info("Test!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
