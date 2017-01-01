package net.estinet.gFeatures.Feature.gHub;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.gHub.crystal.MGServer;
import net.estinet.gFeatures.Feature.gHub.crystal.MGServerPlus;

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

public class Basis {
	public static HashMap<Location, MGServer> crystals = new HashMap<>();
	public static List<String> stacker = new ArrayList<>();
	public static boolean recieving = false;
	public static List<MGServerPlus> servers = new ArrayList<>();
	public static List<MGServerPlus> assemble = new ArrayList<>();
	public static void addStacker(String playername){
		stacker.add(playername);
	}
	public static void removeStacker(String playername){
		stacker.remove(playername);
	}
	public static boolean isInStacker(String playername){
		return stacker.contains(playername);
	}
	public static void setSpawn(Location loc){
		File f = new File("plugins/gFeatures/gHub/spawn.txt");
		f.delete();
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter(f, true));
			output.write(loc.getWorld().getName());
			output.newLine();
			output.write("" + loc.getX());
			output.newLine();
			output.write("" + loc.getY());
			output.newLine();
			output.write("" + loc.getZ());
			output.newLine();
			output.write("" + loc.getYaw());
			output.newLine();
			output.write("" + loc.getPitch());
			output.newLine();
			output.close();
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
		gHub.spawn = loc;
	}
	public static List<MGServerPlus> getServersWithType(String type){
		List<MGServerPlus> list = new ArrayList<>();
		for(MGServerPlus mgsp : servers){
			if(mgsp.getName().contains(type)){
				list.add(mgsp);
			}
		}
		return list;
	}
}
