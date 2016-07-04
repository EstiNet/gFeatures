package net.estinet.gFeatures.Feature.Gliders.MapsSpec;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.Gliders.Basic;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class MapOne {
	
	public static List<Location> planespawn;
	public static List<Location> towerspawn;
	public static Location spectatespawn;
	public static Location flag;
	
	public MapOne(){
		planespawn.add(new Location(Bukkit.getWorld("Gliders"), 769.5, 238.5, -563.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders"), 751.5, 238.5, -563.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders"), 734.5, 238.5, -568.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders"), 481.5, 224.5, -566.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders"), 497.5, 224.5, -565.5));
	}
	
	File f = new File("plugins/gFeatures/Gliders/Gliders1");
	File fz = new File("./CTF");
	public void justDoIt(){
		fz.delete();
		try {
			FileUtils.copyDirectory(f, fz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		WorldCreator cs1 = new WorldCreator("Gliders");
		Bukkit.getServer().createWorld(cs1);
		Basic.mapName = "LargeIsland";
		
	}
}
