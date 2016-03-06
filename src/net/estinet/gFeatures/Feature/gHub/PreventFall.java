package net.estinet.gFeatures.Feature.gHub;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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

public class PreventFall {
	public void check(){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getLocation().getY() < 110){
				p.teleport(new Location(Bukkit.getWorld("EstiNet"), -72.5, 236, -10.5));
			}
		}
	}
}
