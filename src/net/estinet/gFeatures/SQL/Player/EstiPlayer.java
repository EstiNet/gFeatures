package net.estinet.gFeatures.SQL.Player;

import java.io.Serializable;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.gFeature;

public class EstiPlayer<T, V> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1624113009039883572L;
	
	private String name;
	private String UUID;
	private HashMap<gFeature, EstiSet<T, V>> data = new HashMap<>();
	
	public EstiPlayer(Player p){
		name = p.getName();
		UUID = p.getUniqueId().toString();
	}
	public EstiPlayer(Player p, HashMap<gFeature, EstiSet<T, V>> info){
		name = p.getName();
		UUID = p.getUniqueId().toString();
		data = info;
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
	public HashMap<gFeature, EstiSet<T, V>> getData(){
		return data;
	}
	public Player getPlayer(){
		Player player = null;
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getUniqueId().equals(UUID)){
				player = p;
				break;
			}
		}
		return player;
	}
	public void addSet(gFeature plugin, EstiSet<T, V> datas){
		data.put(plugin, datas);
	}
	public void addData(gFeature plugin, Key<V> key, T value){
		data.get(plugin).addData(key, value);
	}
	public void setData(gFeature plugin, Key<V> key, T value){
		data.get(plugin).setData(key, value);
	}
	public void removeData(gFeature plugin, Key<V> key){
		data.get(plugin).getData().remove(key);
	}
	public Object getData(gFeature plugin, Key<V> key){
		return data.get(plugin).getData(key);
	}
}
