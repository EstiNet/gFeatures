package net.estinet.gFeatures.API.Minigame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class Arena{
	
	public static String name;
	public static HashMap<String, Location> spawns = new HashMap<>();
	public static List<Player> players = new ArrayList<>();
	
	Arena(String names){
		names = name;
	}
	Arena(String names, HashMap<String, Location> spawning){
		names = name;
		spawns = spawning;
	}
	public void addPlayer(Player p){
		players.add(p);
	}
	public void removePlayer(Player p){
		players.remove(p);
	}
	public Location getSpawn(String str){
		Location loc = spawns.get(str);
		return loc;
	}
}
