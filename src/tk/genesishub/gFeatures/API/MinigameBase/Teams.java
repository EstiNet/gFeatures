package tk.genesishub.gFeatures.API.MinigameBase;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Teams {
	public static List<Player> players = new ArrayList<>();
	
	public void addPlayer(Player p){
		players.add(p);
	}
	public void removePlayer(Player p){
		players.remove(p);
	}
}
