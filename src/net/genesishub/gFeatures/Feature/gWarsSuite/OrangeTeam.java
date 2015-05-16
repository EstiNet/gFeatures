package net.genesishub.gFeatures.Feature.gWarsSuite;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class OrangeTeam {
	private static List<Player> ot = new ArrayList<>();
	public void addPlayer(Player p){
		ot.add(p);
	}
	public void removePlayer(Player p){
		ot.remove(p);
	}
	public void setList(List<Player> list){
		ot = list;
	}
	public List<Player> getList(){
		return ot;
	}
}
