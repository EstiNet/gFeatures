package net.estinet.gFeatures.Feature.EstiTicket;

import net.estinet.gFeatures.gFeature;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
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

public class EstiTicket extends gFeature {
	
	public EstiTicket(String featurename, String version) {
		super(featurename, version);
	}
	@Override
	public void enable(){
		ConfigHub.setupConfig();
		Bukkit.getLogger().info("[EstiTicket] Enabled!");
	}
	@Override
	public void disable(){
		Bukkit.getLogger().info("[EstiTicket] Disabled!");
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){}
}
