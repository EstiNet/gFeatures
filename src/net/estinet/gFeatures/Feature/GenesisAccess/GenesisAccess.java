package net.estinet.gFeatures.Feature.GenesisAccess;

import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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

public class GenesisAccess extends gFeature{
	
	net.estinet.gFeatures.Feature.GenesisAccess.Main main = new net.estinet.gFeatures.Feature.GenesisAccess.Main();
	
	public GenesisAccess(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		main.onEnable();
	}
	@Override
	public void disable(){
		main.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			main.PlayerJoinEvent((PlayerJoinEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			main.PlayerleaveEvent((PlayerQuitEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("asyncplayerchatevent")){
			main.PlayerChatEvent((AsyncPlayerChatEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playercommandpreprocessevent")){
			main.PlayerCommandEvent((PlayerCommandPreprocessEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdeathevent")){
			main.PlayerSlainEvent((PlayerDeathEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Retrieval
	public void onPlayerQuit(){}
	@Retrieval
	public void onPlayerChat(){}
	@Retrieval
	public void onPlayerCommand(){}
	@Retrieval
	public void onPlayerDeath(){}
}
