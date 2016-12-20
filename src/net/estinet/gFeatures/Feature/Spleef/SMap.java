package net.estinet.gFeatures.Feature.Spleef;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;

public class SMap extends FusionMap{
	public SMap(File f, List<Location> spawns) {
		super(f, spawns);
	}
	public SMap(File file) {
		super(file);
		List<Location> locs = new ArrayList<>(); //plz change
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -804, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -807, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -810, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -813, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -816, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -819, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -822, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -824, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -826, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -829, -0, 90));
		super.setSpawns(locs);
	}
	public void reassign(){
		List<Location> locs = new ArrayList<>(); //plz change
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -804, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -807, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -810, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -813, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -816, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -819, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -822, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -824, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -826, -0, 90));
		locs.add(new Location(Bukkit.getWorld("world"), 11, 43.5, -829, -0, 90));
		super.setSpawns(locs);
		}
}
