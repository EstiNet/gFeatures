package net.estinet.gFeatures.Utility.gMotd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gUtility;

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

public class gMotd extends gUtility{
	
	public gMotd(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		YMLSetter ymls = new YMLSetter();
		ymls.enableCheck();
		Bukkit.getLogger().info("[gMotd] Enabled.");
	}
	@Override
	public void disable(){
		Bukkit.getLogger().info("[gMotd] Disabled.");
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			PlayerJoinEvent events = (PlayerJoinEvent) event;
			String motd = YMLSetter.getMotd();
			String motds = motd.replace("{PLAYER}", events.getPlayer().getName());
			events.getPlayer().sendMessage(motds);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) {}
}
