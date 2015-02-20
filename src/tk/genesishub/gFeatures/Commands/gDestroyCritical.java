package tk.genesishub.gFeatures.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.gDestroyCritical.CommandManager;

public class gDestroyCritical {
public String CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args){
		CommandManager ch = new CommandManager();
		ch.onCommands(sender, cmd, label, args);
		return null;
	}
}
