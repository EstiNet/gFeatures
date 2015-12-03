package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import net.estinet.gFeatures.API.Logger.Debug;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

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
	public Location getSpawn(){
		return spawnlocation;
	}
	public CaptureState getCaptureState(){
		return capturestate;
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
	@SuppressWarnings("deprecation")
	public void setNeutral(){
		List<Block> blocks = new ArrayList<>();
		for(Location loc : location){
			blocks.add(loc.getBlock());
		}
		for(Block block : blocks){
			block.setData((byte)0);
		}
	}
	public boolean isInLocation(Location loc){
		for(Location locs : location){
			Debug.print("[gCheck] Player x " + Math.floor(loc.getX()) + " point x " + Math.floor(locs.getX()) + " Player z " + Math.floor(loc.getBlockZ()) + " point z " + Math.floor(locs.getZ()));
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
		case blue1:
			break;
		case blue2:
			break;
		case white:
			break;
		case orange:
			break;
		case orange1:
			break;
		case orange2:
			break;
		}
	}
}
