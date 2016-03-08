package net.estinet.gFeatures.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandExecutable{
	CommandSender sender = null;
	Command cmd = null;
	String[] args = null;
	
	public void run();
}
