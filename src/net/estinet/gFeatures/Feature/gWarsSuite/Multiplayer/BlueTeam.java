package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import java.util.ArrayList;
import java.util.List;

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

public class BlueTeam {
	private final String town = "Innisfil";
	private static List<Player> bt = new ArrayList<>();
	public static void addPlayer(Player p){
		bt.add(p);
	}
	public static void removePlayer(Player p){
		bt.remove(p);
	}
	public static int size(){
		return bt.size();
	}
	public static void setList(List<Player> list){
		bt = list;
	}
	public static boolean hasPlayer(Player p){
		for(Player player : bt){
			if(p.getName().equalsIgnoreCase(player.getName())){
				return true;
			}
		}
		return false;
	}
	public static List<Player> getList(){
		return bt;
	}
	public String getTownName(){
		return town;
	}
}
