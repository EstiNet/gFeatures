package net.estinet.gFeatures.Feature.gHub.crystal;

public class MGServerPlus {
	private String name;
	private String state;
	private int numOfPlayers;
	public MGServerPlus(String name, String state, String numOfPlayers){
		this.name = name;
		this.state = state;
		this.numOfPlayers = Integer.parseInt(numOfPlayers);
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
}
