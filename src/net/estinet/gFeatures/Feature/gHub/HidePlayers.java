package net.estinet.gFeatures.Feature.gHub;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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

public class HidePlayers {
	public void show(Player p){
		for(Player player : Bukkit.getOnlinePlayers()){
			if(!p.getUniqueId().equals(player.getUniqueId())){
				p.showPlayer(player);
			}
		}
		Constants.playerOn.remove(p.getUniqueId());
		Constants.playerOn.put(p.getUniqueId(), true);
	}
	public void hide(Player p){
		for(Player player : Bukkit.getOnlinePlayers()){
			if(!p.getUniqueId().equals(player.getUniqueId())){
				p.hidePlayer(player);
			}
		}
		Constants.playerOn.remove(p.getUniqueId());
		Constants.playerOn.put(p.getUniqueId(), false);
	}
}
