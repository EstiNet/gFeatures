package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Feature.Shop.Enums.Trails;

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

public class EventHub{
	public void onPlayerJoin(PlayerJoinEvent event){

		Thread thr = new Thread(() -> {
			String value = Shop.syncCommands.get("trails-" + event.getPlayer().getUniqueId());
			if(value == null){
				SetTrail st = new SetTrail();
				st.init(event.getPlayer(), Trails.NONE);
			}
			for(Trails trail : Trails.values()){
				if(Shop.syncCommands.get("trails-" + event.getPlayer().getUniqueId() + "-" + trail.toString()) == null){
					Shop.syncCommands.set("trails-" + event.getPlayer().getUniqueId() + "-" + trail.toString(), "false");
				}
			}
			Shop.playerTrail.put(event.getPlayer().getUniqueId(), value);
		});
		thr.start();
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		Shop.playerTrail.remove(event.getPlayer().getUniqueId());
	}
}
