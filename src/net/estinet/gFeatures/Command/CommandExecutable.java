package net.estinet.gFeatures.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class CommandExecutable{
	protected CommandSender sender;
	protected Command cmd;
	protected String[] args;
	
	public abstract void run();
}
