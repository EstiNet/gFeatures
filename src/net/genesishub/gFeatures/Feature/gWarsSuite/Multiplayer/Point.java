package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;

public class Point {
	private String name;
	private List<Location> location = new ArrayList<>();
	public Point(String nam, Location upper, Location lower){
		name = nam;
		location.add(upper);
		World world = upper.getWorld();
		if(upper.getBlockX() < lower.getBlockX()){
			for(int i = upper.getBlockX();i == lower.getBlockX(); i++){
				if(upper.getBlockZ() < lower.getBlockZ()){
				for(int id = upper.getBlockZ();i == lower.getBlockZ(); id++){
					location.add(new Location(world, i, upper.getBlockY(), id));
				}
			}
		}
		}
		else if(upper.getBlockX() > lower.getBlockX()){
			for(int i = upper.getBlockX();i == lower.getBlockX(); i--){
				location.add(new Location(world, i, upper.getBlockY(), upper.getBlockZ()));
			}
		}
		
	}
	public String getName(){
		return name;
	}
	public void setOrange(){
		
	}
	public void setBlue(){
		
	}
}
