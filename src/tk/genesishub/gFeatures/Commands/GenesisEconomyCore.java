package tk.genesishub.gFeatures.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.earth2me.essentials.api.UserDoesNotExistException;

import tk.genesishub.gFeatures.GenesisEconomy.Listeners;
import tk.genesishub.gFeatures.PluginManage.GenesisEconomyPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class GenesisEconomyCore {
	public void CommandSwitch(final CommandSender sender, Command cmd, String label, String[] args) throws IOException, IllegalArgumentException, IllegalStateException, UserDoesNotExistException{
		Commands c = new Commands();
		Listeners ch = new Listeners();
		if(GenesisEconomyPlugin.getState().equals(PluginState.ENABLE)){
		ch.onCommand(sender, cmd, label, args);
		}
		else if(c.Check("gEconomyCommands", cmd.getName())){
			sender.sendMessage("GenesisHub does not recognize this command. Type /help for help.");
		}   
	}
}
