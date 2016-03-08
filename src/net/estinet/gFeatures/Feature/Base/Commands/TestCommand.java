package net.estinet.gFeatures.Feature.Base.Commands;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.Command.CommandExecutable;

public class TestCommand implements CommandExecutable{

	@Override
	public void run() {
		Bukkit.getLogger().info("Test!");
	}
	
}
