package net.estinet.gFeatures.SQL.Player;

import java.io.Serializable;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class EstiPlayer<T, V> implements Serializable{
	private static final long serialVersionUID = -1624113009039883572L;
	
	private String name;
	private String UUID;
	private HashMap<String, EstiSet<T, V>> data = new HashMap<>();
	
	public EstiPlayer(Player p){
		name = p.getName();
		UUID = p.getUniqueId().toString();
	}
	public EstiPlayer(Player p, HashMap<String, EstiSet<T, V>> info){
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
	public HashMap<String, EstiSet<T, V>> getData(){
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
	public void addSet(String pluginname, EstiSet<T, V> datas){
		data.put(pluginname, datas);
	}
	public void addData(String plugin, Key<V> key, T value){
		data.get(plugin).addData(key, value);
	}
	public void setData(String plugin, Key<V> key, T value){
		data.get(plugin).setData(key, value);
	}
	public void removeData(String plugin, Key<V> key){
		data.get(plugin).getData().remove(key);
	}
	public Object getData(String plugin, Key<V> key){
		Bukkit.getLogger().info(data.get(plugin).getData(key) + " " + data.keySet().toArray()[0].toString() + " " + data.get(plugin).getValueSet().toArray()[0] + " " + data.get(plugin).getKeySet().toArray()[0] + " " + key);
		return data.get(plugin).getData(key);
	}
}
