package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

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
