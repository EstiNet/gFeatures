package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.Feature.CTF.Maps;

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

public class Spec {
	MapTwo mt = new MapTwo();
	MapOne mo = new MapOne();
	public void direction(Maps map){
		switch(map){
		case One: 
			Bukkit.getLogger().info("[CTF] Map one selected!");
			mo.justDoIt();
			break;
		case Two:
			Bukkit.getLogger().info("[CTF] Map Two selected!");
			mt.justDoIt();
			break;
		default:
			Bukkit.getLogger().info("Wat");
		}
	}
}
