package net.estinet.gFeatures.Feature.Statistics;

import net.estinet.gFeatures.API.PlayerStats.gPlayer;

import net.estinet.gFeatures.gFeatures;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class EventHub implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		gPlayer player = gFeatures.getgPlayer(event.getPlayer().getName());
		String value = gFeatures.getgPlayer(event.getPlayer().getUniqueId().toString()).getValue("Statistics.LoginCount");
		int count = Integer.parseInt(value);
		String finalvalue = Integer.toString(count += 1);
		Bukkit.getLogger().info(finalvalue);
		player.setValue("Statistics.LoginCount", finalvalue);
		Bukkit.getLogger().info(player.getValue("Statistics.LoginCount"));//TODO
		gFeatures.setgPlayer(gFeatures.getgPlayer(event.getPlayer().getUniqueId().toString()), player);
	}
}
