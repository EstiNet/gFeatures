package tk.genesishub.gFeatures.API.MinigameBase;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Teams {
	public static List<Player> players = new ArrayList<>();
	public static String teamname;
	public static int timebeforegame;
	
	public Teams(String name){
		teamname = name;
	}
	
	public void setTimeBeforeGame(int i){
		timebeforegame = i;
	}
	public void addPlayer(Player p){
		players.add(p);
	}
	public void removePlayer(Player p){
		players.remove(p);
	}
	public List<Player> getPlayers(){
		return players;
	}
	public void setName(String name){
		teamname = name;
	}
	public int length(){
		return players.size();
	}
	public String getName(){
		return teamname;
	}
}
