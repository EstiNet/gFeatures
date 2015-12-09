package net.estinet.gFeatures.SQL.Player;

import java.util.HashMap;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.gFeature;

public class EstiPlayer<T, V> {
	private Player player;
	private String name;
	private String UUID;
	private HashMap<gFeature, EstiSet<T, V>> data = new HashMap<>();
	
	public EstiPlayer(Player p){
		name = p.getName();
		UUID = p.getUniqueId().toString();
		player = p;
	}
	public EstiPlayer(Player p, HashMap<gFeature, EstiSet<T, V>> info){
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
	public void setName(String names){
		name = names;
	}
	public void setUUID(String UUIDs){
		UUID = UUIDs;
	}
	public void setPlayer(Player p){
		player = p;
	}
	public HashMap<gFeature, EstiSet<T, V>> getData(){
		return data;
	}
	public Player getPlayer(){
		return player;
	}
	public void addSet(gFeature plugin, EstiSet<T, V> datas){
		data.put(plugin, datas);
	}
	public void addData(gFeature plugin, Key<V> key, T value){
		data.get(plugin).addData(key, value);
	}
	public void removeData(gFeature plugin, Key<V> key){
		data.get(plugin).getData().remove(key);
	}
}
