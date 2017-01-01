package net.estinet.gFeatures.Feature.ParkourRace.Maps;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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
