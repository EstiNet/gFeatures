package net.estinet.gFeatures.Feature.Spleef;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class SMap extends FusionMap{
	public static Location spectate = new Location(Bukkit.getWorld("world"), -297, 38, -890);
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
		spectate = new Location(Bukkit.getWorld("world"), -297, 38, -890);
		List<Location> locs = new ArrayList<>();
		for(int i = 0; i < 50; i++){
			locs.add(new Location(Bukkit.getWorld("world"), Math.floor(Math.random()*50)-323, 27, Math.floor(Math.random()*50)-914));
		}
		super.setSpawns(locs);
		}
}
