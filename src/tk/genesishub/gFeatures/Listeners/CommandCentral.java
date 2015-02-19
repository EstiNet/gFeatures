package tk.genesishub.gFeatures.Listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.Commands.gFeatureCore;

public class CommandCentral {

	gFeatureCore gfc  = new gFeatureCore();
	public void CommandInitiate(final CommandSender sender, Command cmd, String label, String[] args){
		gfc.CommandSwitch(sender, cmd, label, args);
		//gFeatureCore
	}
}
