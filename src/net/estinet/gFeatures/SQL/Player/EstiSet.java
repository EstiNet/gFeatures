package net.estinet.gFeatures.SQL.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class EstiSet<T> {
	private String tag;
	private HashMap<Key, T> data = new HashMap<>();
	
	public EstiSet(){}
	public EstiSet(HashMap<Key, T> datas){
		data = datas;
	}
	public EstiSet(HashMap<Key, T> datas, String tags){
		data = datas;
		tag = tags;
	}
	
	public void addData(Key key, T info){
		data.put(key, info);
	}
	public void removeData(Key key){
		
	}
	public HashMap<Key, T> getData(){
		return data;
	}
	public T getData(Key key){
		return data.get(key);
	}
	public void clearData(){
		data = new HashMap<>();
	}
	public void setData(HashMap<Key, T> datas){
		data = datas;
	}
	public void setData(Key key, T value){
		data.remove(key);
		data.put(key, value);
	}
	public Set<Key> getKeySet(){
		return data.keySet();
	}
	public Collection<T> getValueSet(){
		return data.values();
	}
	public boolean containsValue(T value){
		return data.containsValue(value);
	}
	public boolean containsKey(Key key){
		return data.containsKey(key);
	}
}
