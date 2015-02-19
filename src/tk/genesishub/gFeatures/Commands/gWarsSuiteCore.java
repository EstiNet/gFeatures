package tk.genesishub.gFeatures.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.gWarsSuite.CommandHub;

public class gWarsSuiteCore {
	public String CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		CommandHub ch = new CommandHub();
		ch.CommandInitiate(sender, cmd, label, args);
		return null;
	}
}
