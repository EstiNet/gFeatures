package tk.genesishub.gFeatures.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.PluginManage.CTFPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;

public class CTFCore {
	public void CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		Commands c = new Commands();
		if(CTFPlugin.getState().equals(PluginState.ENABLE)){
		
		}
		else if(c.Check("CTF", cmd.getName())){
			sender.sendMessage("GenesisHub does not recognize this command. Type /help for help.");
		}
	}
}
