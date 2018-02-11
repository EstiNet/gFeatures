package net.estinet.gFeatures.Feature.Gliders;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

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

public class Basic {
	public static List<Location> planespawn;
	public static List<Location> towerspawn;
	public static Location spectatespawn;
	public static Location waitspawn = new Location(Bukkit.getWorld("MinigameSpawn"), 76.5, 96.5, 91.5);
	public static Location flag;
	public static Player flagger = null;
	public static int countdown = 60;  //CHANGE TO 60 when complete game
	public static int minutes = 5;
	public static int seconds = 0;
	public static String mapName = "";
	public static HashMap<UUID, Integer> kills = new HashMap<>();
	public static HashMap<UUID, Integer> deaths = new HashMap<>();
	public static HashMap<UUID, PlayerMode> modes = new HashMap<>();
	public static HashMap<UUID, Team> teams = new HashMap<>();
	public static Mode mode = Mode.WAITING;
	public static Team winningteam = null;
	public static boolean swap = false;
	public static Team firstteam = null;
	
	public static boolean isInOrange(Player p){
		if(teams.get(p.getUniqueId()).equals(Team.ORANGE)){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isInBlue(Player p){
		if(teams.get(p.getUniqueId()).equals(Team.BLUE)){
			return true;
		}
		else{
			return false;
		}
	}
	public static int getOrangeSize(){
		int ret = 0;
		for(Team t : teams.values()){
			if(t.equals(Team.ORANGE)){
				ret++;
			}
		}
		return ret;
	}
	public static int getBlueSize(){
		int ret = 0;
		for(Team t : teams.values()){
			if(t.equals(Team.BLUE)){
				ret++;
			}
		}
		return ret;
	}
}
