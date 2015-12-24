package net.estinet.gFeatures.SQL.Player;

import java.io.Serializable;

public class Key<V> implements Serializable{
	private static final long serialVersionUID = 5168316688355794593L;
	private V object;
	
	public Key(V objects){
		object = objects;
	}
	public Key(){}
	
	public void setKey(V objects){
		object = objects;
	}
	public V getKey(){
		return object;
	}
}
