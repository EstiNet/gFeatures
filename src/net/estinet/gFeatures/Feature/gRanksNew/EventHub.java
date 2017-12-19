package net.estinet.gFeatures.Feature.gRanksNew;

import net.estinet.gFeatures.SQL.Player.EstiPlayer;
import net.estinet.gFeatures.SQL.Player.Key;
import net.estinet.gFeatures.gFeatures;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

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

public class EventHub{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void onPlayerJoin(PlayerJoinEvent event){
		Bukkit.getLogger().info("Player Joined!");
		Bukkit.getLogger().info("Health: " + gFeatures.getEstiPlayer(event.getPlayer().getUniqueId().toString()).getData(gFeatures.getFeature("Base").getName(), new Key("Health")));
		Bukkit.getLogger().info("Setting it to 21");
		EstiPlayer play = gFeatures.getEstiPlayer(event.getPlayer().getUniqueId().toString());
		play.setData(gFeatures.getFeature("Base").getName(), new Key("Health"), "21");
		gFeatures.setEstiPlayer(gFeatures.getEstiPlayer(event.getPlayer().getUniqueId().toString()), play);
	}
}
