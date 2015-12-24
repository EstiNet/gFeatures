package tk.genesishub.gFeatures.API.MinigameBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

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
