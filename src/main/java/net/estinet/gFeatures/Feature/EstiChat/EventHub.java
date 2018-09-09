package net.estinet.gFeatures.Feature.EstiChat;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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

public class EventHub implements Listener {
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(event.getPlayer().getName() + " <" + event.getPlayer().getDisplayName() + "> " + event.getMessage()), "chat", "Bungee");
		EstiChat.lastSent = event.getMessage();
	}
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
	    ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes(event.getEntity().getName() + " " + event.getDeathMessage()), "chat", "Bungee");
		EstiChat.lastSent = event.getDeathMessage();
	}
}
