package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import java.util.ArrayList;
import java.util.List;

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

public class OrangeTeam {
	private final String town = "Kloyne";
	private static List<Player> ot = new ArrayList<>();
	public static void addPlayer(Player p){
		ot.add(p);
	}
	public static void removePlayer(Player p){
		ot.remove(p);
	}
	public static int size(){
		return ot.size();
	}
	public static void setList(List<Player> list){
		ot = list;
	}
	public static boolean hasPlayer(Player p){
		for(Player player : ot){
			if(p.getName().equals(player.getName())){
				return true;
			}
		}
		return false;
	}
	public static List<Player> getList(){
		return ot;
	}
	public String getTownName(){
		return town;
	}
}
