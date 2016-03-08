package net.estinet.gFeatures.Feature.Base.Commands;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.Command.CommandExecutable;

public class TestCommand extends CommandExecutable{

	@Override
	public void run() {
		Bukkit.getLogger().info("Test! I can implement " + cmd.getDescription());
	}
	
}
