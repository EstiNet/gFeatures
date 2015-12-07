package net.estinet.gFeatures.SQL.Player;

import java.util.HashMap;

public class EstiSet<T> {
	private HashMap<Key, T> data = new HashMap<>();
	
	public EstiSet(){}
	public EstiSet(HashMap<Key, T> datas){
		data = datas;
	}
	
	public void addData(Key key, T info){
		data.put(key, info);
	}
	
}
