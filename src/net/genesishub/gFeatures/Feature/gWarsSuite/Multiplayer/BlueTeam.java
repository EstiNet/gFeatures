package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class BlueTeam {
	private static List<Player> bt = new ArrayList<>();
	public void addPlayer(Player p){
		bt.add(p);
	}
	public void removePlayer(Player p){
		bt.remove(p);
	}
	public void setList(List<Player> list){
		bt = list;
	}
	public List<Player> getList(){
		return bt;
	}
}
