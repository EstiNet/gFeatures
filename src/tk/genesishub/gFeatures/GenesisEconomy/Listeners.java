package tk.genesishub.gFeatures.GenesisEconomy;

import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

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

public class Listeners {
	private static final Logger log = Logger.getLogger("Minecraft");
    public static Economy econ = null;
    public static Permission perms = null;
    public static Chat chat = null;
	public void onEnable(){
		Bukkit.getLogger().info("GenesisEconomy enabled. You're good to go!");
		if (!Econist.setupEconomy() ) {
            GenesisEconomyPlugin.setPluginState(PluginState.DISABLE);
            return;
        }
        Econist.setupPermissions();
        Econist.setupChat();
	}
	public void onDisable(){
		Bukkit.getLogger().info("GenesisEconomy disabled. Good bye!");
	}

    public void onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
    	CommandHub ch = new CommandHub();
    	ch.Intitiate(sender, command, commandLabel, args);
    }
}
