package net.estinet.gFeatures.Feature.ParkourRace.Maps;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;

public abstract class PRMap extends FusionMap{
	public PRMap(File f) {
		super(f);
	}
	public PRMap(File f, List<Location> spawns){
		super(f, spawns);
	}
	public int pastDistanceZ;
	public int lowDistance;
	public int checkPointZ;
	public Location p1;
	public Location p2;
	public String name = "Classic";
	public List<Location> checkpointSpawns = new ArrayList<>();
	public abstract void reassign();
}
