package net.estinet.gFeatures.SQL.Player;

import java.util.HashMap;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.gFeature;

public class EstiPlayer {
	private Player player;
	private String name;
	private String UUID;
	private HashMap<gFeature, EstiSet> data = new HashMap<>();
	
	public EstiPlayer(Player p){
		name = p.getName();
		UUID = p.getUniqueId().toString();
		player = p;
	}
	public EstiPlayer(Player p, HashMap<gFeature, EstiSet> info){
		name = p.getName();
		UUID = p.getUniqueId().toString();
		data = info;
		player = p;
	}
	public String getName(){
		return name;
	}
	public String getUUID(){
		return UUID;
	}
	public HashMap<gFeature, EstiSet> getData(){
		return data;
	}
	public Player getPlayer(){
		return player;
	}
	public void addData(gFeature plugin, EstiSet datas){
		data.put(plugin, datas);
	}
	public void removeData(gFeature plugin, Key key){
		
	}
}
