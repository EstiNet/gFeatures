package net.estinet.gFeatures.Feature.Base;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.EstiSet;
import net.estinet.gFeatures.SQL.Player.Key;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void onPlayerJoin(PlayerJoinEvent event){
		Bukkit.getLogger().info("Player Joined!");
		Bukkit.getLogger().info("Health: " + Basic.getEstiPlayer(event.getPlayer().getUniqueId().toString()).getData(Basic.getFeature("Base").getName(), new Key("Health")));
		Bukkit.getLogger().info("Setting it to 21");
		EstiPlayer play = Basic.getEstiPlayer(event.getPlayer().getUniqueId().toString());
		play.setData(Basic.getFeature("Base").getName(), new Key("Health"), "21");
		Basic.setEstiPlayer(Basic.getEstiPlayer(event.getPlayer().getUniqueId().toString()), play);
	}
}
