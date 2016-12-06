package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class FusionMap {
	private File f = null;
	private List<Location> spawns = new ArrayList<>();
	public File getFile(){
		return f;
	}
	public void setFile(File f){
		this.f = f;
	}
	public List<Location> getSpawns(){
		return spawns;
	}
	public void setSpawns(List<Location> spawns){
		this.spawns = spawns;
	}
	public void addSpawn(Location loc){
		spawns.add(loc);
	}
}
