package net.estinet.gFeatures.Feature.gHub.crystal;

public class MGServerPlus {
	private String name;
	private String state;
	private int numOfPlayers;
	private String map;
	public MGServerPlus(String name, String state, String numOfPlayers, String map){
		this.name = name;
		this.state = state;
		this.numOfPlayers = Integer.parseInt(numOfPlayers);
		this.map = map;
	}
	public String getName(){
		return name;
	}
	public String getState(){
		return state;
	}
	public int getNumOfPlayers(){
		return numOfPlayers;
	}
	public String getMap(){
		return map;
	}
}
