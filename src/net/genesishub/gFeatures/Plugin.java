package net.genesishub.gFeatures;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface Plugin {
	public void enable();
	public void disable();
	public void eventTrigger();
	public void commandTrigger(final CommandSender sender, Command cmd, String label, String[] args);
}
