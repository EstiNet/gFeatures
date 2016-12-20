package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public abstract class FusionMap {
	private File f = null;
	private List<Location> spawns = new ArrayList<>();
	public FusionMap(File f){
		this.f = f;
	}
	public FusionMap(File f, List<Location> spawns){
		this.spawns = spawns;
		this.f = f;
	}
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
	//must override plz
	public abstract void reassign();
}
