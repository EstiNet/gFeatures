package net.genesishub.gFeatures.Feature.GenesisBackup;

import java.io.IOException;

import net.genesishub.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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

public class GenesisBackup extends gFeature{
	
	net.genesishub.gFeatures.Feature.GenesisBackup.Listeners listeners = new net.genesishub.gFeatures.Feature.GenesisBackup.Listeners();
	
	public GenesisBackup(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		try {
			listeners.onEnable();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void disable(){
		listeners.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
	}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			listeners.onCommand(sender, cmd, label, args);
	}
}
