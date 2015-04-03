package tk.genesishub.gFeatures.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gMusicPlugin;
import tk.genesishub.gFeatures.gMusic.CommandCenter;

public class gMusicCore {
	public void CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args) throws NumberFormatException, Exception{
		Commands c = new Commands();
		CommandCenter ch = new CommandCenter();
		if(gMusicPlugin.getState().equals(PluginState.ENABLE)){
		ch.CommandInitiate(sender, cmd, label, args);
		}
		else if(c.Check("gMusic", cmd.getName())){
			sender.sendMessage("GenesisHub does not recognize this command. Type /help for help.");
		}
	}
}
