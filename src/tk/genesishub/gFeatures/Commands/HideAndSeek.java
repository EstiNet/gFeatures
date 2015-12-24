package tk.genesishub.gFeatures.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tk.genesishub.gFeatures.GenesisEconomy.Listeners;
import tk.genesishub.gFeatures.PluginManage.HideAndSeekPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;

import com.earth2me.essentials.api.UserDoesNotExistException;

public class HideAndSeek {
	public void CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args) throws IOException, IllegalArgumentException, IllegalStateException, UserDoesNotExistException{
		Commands c = new Commands();
		Listeners ch = new Listeners();
		if(HideAndSeekPlugin.getState().equals(PluginState.ENABLE)){
		ch.onCommand(sender, cmd, label, args);
		}
		else if(c.Check("HideAndSeek", cmd.getName())){
			sender.sendMessage("GenesisHub does not recognize this command. Type /help for help.");
		}   
	}
}
