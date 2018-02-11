package net.estinet.gFeatures.Feature.ParkourRace.Maps;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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

public class MapOne extends PRMap{
	public MapOne(File f, List<Location> spawns) {
		super(f, spawns);
		assign();
	}
	public MapOne(File file) {
		super(file);
		assign();
		List<Location> locs = new ArrayList<>();
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
		super.pastDistanceZ = 154;
		super.lowDistance = 39;
		super.checkPointZ = 69;
		super.name = "Classic";
		super.p1 = new Location(Bukkit.getWorld("world"), 9, 43, -837);
		super.p2 = new Location(Bukkit.getWorld("world"), 9, 44, -801);
	}
	
	public void assign(){
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -804, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -807, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -810, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -813, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -816, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -819, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -822, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -824, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -826, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -829, -0, 90));
	}
	public void reassign(){
		List<Location> locs = new ArrayList<>();
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
		super.pastDistanceZ = 154;
		super.lowDistance = 39;
		super.checkPointZ = 69;
		super.name = "Classic";
		super.p1 = new Location(Bukkit.getWorld("world"), 9, 43, -837);
		super.p2 = new Location(Bukkit.getWorld("world"), 9, 44, -801);
		checkpointSpawns = new ArrayList<>();
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -804, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -807, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -810, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -813, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -816, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -819, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -822, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -824, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -826, -0, 90));
		checkpointSpawns.add(new Location(Bukkit.getWorld("world"), -72, 44.5, -829, -0, 90));
	}
}
