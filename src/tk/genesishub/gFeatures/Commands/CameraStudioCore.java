package tk.genesishub.gFeatures.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;
import tk.genesishub.gFeatures.gWarsSuite.CommandHub;

public class CameraStudioCore {
	public void CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		Commands c = new Commands();
		CommandHub ch = new CommandHub();
		if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
		ch.CommandInitiate(sender, cmd, label, args);
		}
		else if(c.Check("CameraStudio", cmd.getName())){
			sender.sendMessage("GenesisHub does not recognize this command. Type /help for help.");
		}
	}
}
