package tk.genesishub.gFeatures.API.MinigameBase;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {
	public static boolean state = false;
	public static String gamename;
	public static List<Player> players = new ArrayList<>();
	public static int requiredplayers;
	public static List<Teams> teams = new ArrayList<>();
	public static Arena arena;
	public static int timebeforestart;
	
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
}
