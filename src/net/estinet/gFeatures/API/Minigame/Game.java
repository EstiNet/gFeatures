package net.estinet.gFeatures.API.Minigame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

public class Game {
	public static boolean state = false;
	public static String gamename;
	public static List<Player> players = new ArrayList<>();
	public static int requiredplayers;
	public static List<Teams> teams = new ArrayList<>();
	public static Arena arena;
	public static int timebeforestart;
	public static HashMap<String, List<Material>> kits = new HashMap<>();
	
	public static String startmessage;
	
	public Game(String name, int requiredplayer){
		gamename = name;
		requiredplayers = requiredplayer;
	}
	public void setName(String str){
		gamename = str;
	}
	public void setState(boolean stat){
		state = stat;
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	public void removePlayer(Player player){
		players.remove(player);
	}
	public void setCurrentArena(Arena arenas){
		arena = arenas;
	}
	public void addTeam(Teams team){
		teams.add(team);
	}
	public void removeTeam(Teams team){
		teams.remove(team);
	}
	public int getTimeBeforeStart(){
		return timebeforestart;
	}
	public void setTimeBeforeStart(int time){
		timebeforestart = time;
	}
	public Teams getTeam(String name){
		for(Teams team : teams){
			if(team.getName().equals(name)){
				return team;
			}
		}
		return null;
	}
	public Teams getTeam(int index){
		return teams.get(index);
	}
	public boolean checkStart(){
		if(players.size() >= requiredplayers){
			setState(true);
			startGame();
			return true;
		}
		else{
			return false;
		}
	}
	public void setStartMessage(String str){
		startmessage = str;
	}
	public void startGame(){
		Bukkit.getServer().broadcastMessage(startmessage);
	}
	public void KitSelector(){}
}
