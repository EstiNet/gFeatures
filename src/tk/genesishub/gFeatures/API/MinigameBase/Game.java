package tk.genesishub.gFeatures.API.MinigameBase;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Game {
	public static boolean state = false;
	public static String gamename;
	public static List<Player> players = new ArrayList<>();
	public static int requiredplayers;
	
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
	public void checkStart(){
		if(players.size() >= requiredplayers){
			setState(true);
		}
	}
	public void setStartMessage(String str){
		startmessage = str;
	}
}
