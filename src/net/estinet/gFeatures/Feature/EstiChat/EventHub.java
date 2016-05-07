package net.estinet.gFeatures.Feature.EstiChat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

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

public class EventHub{
	public void onPlayerChat(AsyncPlayerChatEvent event){
		  ByteArrayDataOutput out = ByteStreams.newDataOutput();
		  out.writeUTF("Chat");
		  out.writeUTF(event.getMessage());

		  Player player = event.getPlayer();

		  player.sendPluginMessage(Bukkit.getPluginManager().getPlugin("gFeatures"), "BungeeCord", out.toByteArray());
	}
	public void onPlayerDeath(PlayerDeathEvent event){
		  ByteArrayDataOutput out = ByteStreams.newDataOutput();
		  out.writeUTF("Chat");
		  out.writeUTF(event.getDeathMessage());

		  Player player = event.getEntity();

		  player.sendPluginMessage(Bukkit.getPluginManager().getPlugin("gFeatures"), "BungeeCord", out.toByteArray());
	}
}
