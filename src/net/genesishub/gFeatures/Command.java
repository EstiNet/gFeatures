package net.genesishub.gFeatures;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Command {
	public void onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		try{
			
		}
		catch(Exception e){
			Bukkit.getLogger().info("Error occurred when executing a gFeatures command.");
			Bukkit.getLogger().info("Here's the error:");
			e.printStackTrace();
		}
	}
}
