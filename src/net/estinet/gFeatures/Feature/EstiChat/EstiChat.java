package net.estinet.gFeatures.Feature.EstiChat;

import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class EstiChat extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	public static String lastSent = "";
	
	public EstiChat(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		Enable.onEnable();
	}
	@Override
	public void disable(){
		Disable.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("asyncplayerchatevent")){
			eh.onPlayerChat((AsyncPlayerChatEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdeathevent")){
			eh.onPlayerDeath((PlayerDeathEvent)event);
		}
	}
	@Retrieval
	@Override
	public void onPlayerChat(){}
	@Retrieval
	@Override
	public void onPlayerDeath(){}
}
