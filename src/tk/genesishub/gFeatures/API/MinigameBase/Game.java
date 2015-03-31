package tk.genesishub.gFeatures.API.MinigameBase;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Game {
	public static boolean state;
	public static String gamename;
	public static List<Player> players = new ArrayList<>();
	
	public Game(String name){
		gamename = name;
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
}
