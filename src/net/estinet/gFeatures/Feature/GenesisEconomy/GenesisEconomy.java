package net.estinet.gFeatures.Feature.GenesisEconomy;

import java.io.IOException;
import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

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

public class GenesisEconomy extends gFeature{
	
	net.estinet.gFeatures.Feature.GenesisEconomy.Listeners listeners = new net.estinet.gFeatures.Feature.GenesisEconomy.Listeners();
	
	public GenesisEconomy(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		try {
			listeners.onEnable();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void disable(){
		listeners.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			listeners.onPlayerJoin((PlayerJoinEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			try {
				listeners.onCommand(sender, cmd, label, args);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
