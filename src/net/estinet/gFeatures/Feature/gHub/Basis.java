package net.estinet.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;

import net.estinet.gFeatures.Feature.gHub.crystal.MGServer;

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

public class Basis {
	public static HashMap<Location, MGServer> crystals = new HashMap<>();
	public static List<String> stacker = new ArrayList<>();
	public static void addStacker(String playername){
		stacker.add(playername);
	}
	public static void removeStacker(String playername){
		stacker.remove(playername);
	}
	public static boolean isInStacker(String playername){
		return stacker.contains(playername);
	}
}
