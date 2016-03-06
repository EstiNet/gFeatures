package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import net.estinet.gFeatures.API.Logger.Debug;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class Point {
	private String name;
	private Location spawnlocation;
	private CaptureState capturestate;
	private List<Location> location = new ArrayList<>();
	public Point(String nam, Location upper, Location lower, Location spawn, CaptureState cs){
		capturestate = cs;
		name = nam;
		spawnlocation = spawn;
		location.add(upper);
		World world = upper.getWorld();
		Bukkit.getLogger().info("Upper: Block X: " + upper.getBlockX() + " Block Z: " + upper.getBlockZ());
		Bukkit.getLogger().info("Lower: Block X: " + lower.getBlockX() + " Block Z: " + lower.getBlockZ());
		if(upper.getBlockX() < lower.getBlockX()){
			for(int i = upper.getBlockX();i != lower.getBlockX(); i++){
				if(upper.getBlockZ() < lower.getBlockZ()){
					for(int id = upper.getBlockZ();id != lower.getBlockZ(); id++){
						location.add(new Location(world, i, upper.getBlockY(), id));
					}
				}
				else{
					for(int id = upper.getBlockZ();id != lower.getBlockZ(); id--){
						location.add(new Location(world, i, upper.getBlockY(), id));
					}
				}
			}
		}
		else if(upper.getBlockX() > lower.getBlockX()){
			for(int i = upper.getBlockX();i != lower.getBlockX(); i--){
				if(upper.getBlockZ() < lower.getBlockZ()){
					for(int id = upper.getBlockZ();id != lower.getBlockZ(); id++){
						location.add(new Location(world, i, upper.getBlockY(), id));
					}
				}
				else{
					for(int id = upper.getBlockZ();id != lower.getBlockZ(); id--){
						location.add(new Location(world, i, upper.getBlockY(), id));
					}
				}
			}
		}
		
	}
	public List<Location> getLocations(){
		return location;
	}
	public String getName(){
		return name;
	}
	public Location getSpawn(){
		return spawnlocation;
	}
	public CaptureState getCaptureState(){
		return capturestate;
	}
	@SuppressWarnings("deprecation")
	public void setOrange(){
		for(Location location : location){
			Block block = Bukkit.getServer().getWorld("gWars").getBlockAt(location);
			block.setTypeIdAndData(95, (byte) 1, true);
		}
		capturestate = CaptureState.orange;
	}
	@SuppressWarnings("deprecation")
	public void setBlue(){
		for(Location location : location){
			Block block = Bukkit.getServer().getWorld("gWars").getBlockAt(location);
			block.setTypeIdAndData(95, (byte) 3, true);
		}
		capturestate = CaptureState.blue;
	}
	@SuppressWarnings("deprecation")
	public void setNeutral(){
		for(Location location : location){
			Block block = Bukkit.getServer().getWorld("gWars").getBlockAt(location);
			block.setTypeId(95);
		}
		capturestate = CaptureState.white;
	}
	public boolean isInLocation(Location loc){
		for(Location locs : location){
			if(Math.floor(locs.getX()) == Math.floor(loc.getX()) && Math.floor(locs.getZ()) == Math.floor(loc.getBlockZ())){
				return true;
			}
		}
		return false;
	}
	public void upOrange(){
		if(capturestate.equals(CaptureState.orange)){
			return;
		}
		else{
			List<CaptureState> cs = new ArrayList<CaptureState>(Arrays.asList(CaptureState.values()));
			for(CaptureState css : cs){
				if(css.equals(capturestate)){
					int ordinal = css.ordinal();
					cs.get(ordinal += 1);
					convert(Direction.UP);
				}
			}
		}
	}
	public void upBlue(){
		if(capturestate.equals(CaptureState.blue)){
			return;
		}
		else{
			List<CaptureState> cs = new ArrayList<CaptureState>(Arrays.asList(CaptureState.values()));
			for(CaptureState css : cs){
				if(css.equals(capturestate)){
					int ordinal = css.ordinal();
					cs.get(ordinal -= 1);
					convert(Direction.DOWN);
				}
			}
		}
	}
	public void convert(Direction d){
		switch(capturestate){
		case blue:
			break;
		case white:
			break;
		case orange:
			break;
		}
	}
}
