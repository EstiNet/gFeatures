package net.estinet.gFeatures.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandExecutable implements Runnable{
	CommandSender sender;
	Command cmd;
	String[] args;
	
	public CommandExecutable(CommandSender sender, Command cmd, String[] args){
		this.sender = sender;
		this.cmd = cmd;
		this.args = args;
	}

	@Override
	public void run() {}
}
