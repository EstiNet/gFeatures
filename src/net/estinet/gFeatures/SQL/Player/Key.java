package net.estinet.gFeatures.SQL.Player;

public class Key<V> {
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
