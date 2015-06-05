package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Point {
	private String name;
	private List<Location> location = new ArrayList<>();
	private Team currentteam;
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
				else{
					for(int id = upper.getBlockZ();i == lower.getBlockZ(); id--){
						location.add(new Location(world, i, upper.getBlockY(), id));
					}
				}
			}
		}
		else if(upper.getBlockX() > lower.getBlockX()){
			for(int i = upper.getBlockX();i == lower.getBlockX(); i--){
				if(upper.getBlockZ() < lower.getBlockZ()){
					for(int id = upper.getBlockZ();i == lower.getBlockZ(); id++){
						location.add(new Location(world, i, upper.getBlockY(), id));
					}
				}
				else{
					for(int id = upper.getBlockZ();i == lower.getBlockZ(); id--){
						location.add(new Location(world, i, upper.getBlockY(), id));
					}
				}
			}
		}
		
	}
	public String getName(){
		return name;
	}
	@SuppressWarnings("deprecation")
	public void setOrange(){
		List<Block> blocks = new ArrayList<>();
		for(Location loc : location){
			blocks.add(loc.getBlock());
		}
		for(Block block : blocks){
			block.setData((byte)1);
		}
	}
	@SuppressWarnings("deprecation")
	public void setBlue(){
		List<Block> blocks = new ArrayList<>();
		for(Location loc : location){
			blocks.add(loc.getBlock());
		}
		for(Block block : blocks){
			block.setData((byte)3);
		}
	}
}
