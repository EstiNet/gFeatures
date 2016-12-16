package net.estinet.gFeatures.Feature.ParkourRace.Maps;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;

public class MapOne extends FusionMap{
	public int pastDistance = 69;
	public MapOne(File f, List<Location> spawns) {
		super(f, spawns);
	}
	public MapOne(File file) {
		super(file);
		List<Location> locs = new ArrayList<>();
		locs.add(new Location(Bukkit.getWorld("world"), 69, 69, 69));
		super.setSpawns(locs);
	}
	
}
