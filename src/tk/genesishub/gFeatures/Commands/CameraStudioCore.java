package tk.genesishub.gFeatures.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.CameraStudio.CameraStudio;
import tk.genesishub.gFeatures.PluginManage.CameraStudioPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;
import tk.genesishub.gFeatures.gWarsSuite.CommandHub;

public class CameraStudioCore {
	public void CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		Commands c = new Commands();
		CameraStudio ch = new CameraStudio();
		if(CameraStudioPlugin.getState().equals(PluginState.ENABLE)){
		ch.onCommand(sender, cmd, label, args);
		}
		else if(c.Check("CameraStudio", cmd.getName())){
			sender.sendMessage("GenesisHub does not recognize this command. Type /help for help.");
		}
	}
}
