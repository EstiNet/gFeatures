package net.estinet.gFeatures.Feature.gHub.crystal;

import org.bukkit.Location;

public class MGServer {
	private String name;
	private Location crystalLoc;
	public MGServer(String name, Location crystalLocation){
		this.name = name;
		this.crystalLoc = crystalLocation;
	}
	public String getName(){
		return name;
	}
	public Location getLocation(){
		return crystalLoc;
	}
}
