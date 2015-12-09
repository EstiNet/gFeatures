package net.estinet.gFeatures.SQL.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class EstiSet<T, V> {
	private String tag;
	private HashMap<Key<V>, T> data = new HashMap<>();
	
	public EstiSet(){}
	public EstiSet(HashMap<Key<V>, T> datas){
		data = datas;
	}
	public EstiSet(HashMap<Key<V>, T> datas, String tags){
		data = datas;
		tag = tags;
	}
	
	public void setTag(String tags){
		tag = tags;
	}
	public String getTag(){
		return tag;
	}
	public void addData(Key<V> key, T info){
		data.put(key, info);
	}
	public void removeData(Key<V> key){
		data.remove(key);
	}
	public HashMap<Key<V>, T> getData(){
		return data;
	}
	public T getData(Key<V> key){
		return data.get(key);
	}
	public void clearData(){
		data = new HashMap<>();
	}
	public void setData(HashMap<Key<V>, T> datas){
		data = datas;
	}
	public void setData(Key<V> key, T value){
		data.remove(key);
		data.put(key, value);
	}
	public Set<Key<V>> getKeySet(){
		return data.keySet();
	}
	public Collection<T> getValueSet(){
		return data.values();
	}
	public boolean containsValue(T value){
		return data.containsValue(value);
	}
	public boolean containsKey(Key<V> key){
		return data.containsKey(key);
	}
}
