package net.estinet.gFeatures.Feature.CTF;

import java.util.HashMap;
import java.util.UUID;

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

public class Basic {
	public static Location orangespawn;
	public static Location bluespawn;
	public static Location spectatespawn;
	public static Location waitspawn = new Location(Bukkit.getWorld("MinigameSpawn"), 76.5, 96.5, 91.5);
	public static Location orangeflag;
	public static Location blueflag;
	public static Location orangeafterspawn;
	public static Location blueafterspawn;
	public static Player orangeflagger = null;
	public static Player blueflagger = null;
	public static int orangeflags = 0;
	public static int blueflags = 0;
	public static int countdown = 60;  //CHANGE TO 60 when complete game
	public static int minutes = 7;
	public static int seconds = 30;
	public static HashMap<UUID, Integer> kills = new HashMap<>();
	public static HashMap<UUID, Integer> deaths = new HashMap<>();
	public static HashMap<UUID, Integer> flagcaptures = new HashMap<>();
	public static HashMap<UUID, PlayerMode> modes = new HashMap<>();
	public static HashMap<UUID, Team> teams = new HashMap<>();
	public static Mode mode = Mode.WAITING;
	
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
