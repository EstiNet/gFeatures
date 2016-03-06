package net.estinet.gFeatures.Feature.GenesisEconomy;

import java.io.IOException;
import java.sql.SQLException;

import net.estinet.gFeatures.Configuration.Config;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerJoinEvent;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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
	ConfigManager cm = new ConfigManager();
	public void onEnable() throws IOException, SQLException{
		Bukkit.getLogger().info("GenesisEconomy enabled. You're good to go!");
		Enabled e = new Enabled();
		e.Initialize();
		Config con = new Config();
		con.createDirectory("plugins/gFeatures/gEconomy", "Created economy directory!");
	}
	public void onDisable(){
		Bukkit.getLogger().info("GenesisEconomy disabled. Good bye!");
	}
    public void onCommand(CommandSender sender, Command command, String commandLabel, String[] args) throws IllegalArgumentException, IllegalStateException{
    	CommandHub ch = new CommandHub();
    	ch.Intitiate(sender, command, commandLabel, args);
    }
    public void onPlayerJoin(PlayerJoinEvent e){
    	Join j = new Join();
    	j.Initialize(e);
    }
}
