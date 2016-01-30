package net.estinet.gFeatures.Feature.CTF;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Basic {
	public static Location orangespawn;
	public static Location bluespawn;
	public static Location spectatespawn;
	public static Location waitspawn = new Location(Bukkit.getWorld("MinigameSpawn"), 76.5, 96.5, 91.5);
	public static Location orangeflag;
	public static Location blueflag;
	public static Location orangeafterspawn;
	public static Location blueafterspawn;
	public static Player orangeflagger;
	public static Player blueflagger;
	public static int orangeflags = 0;
	public static int blueflags = 0;
	public static int countdown = 5;  //CHANGE TO 60 when complete game
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
