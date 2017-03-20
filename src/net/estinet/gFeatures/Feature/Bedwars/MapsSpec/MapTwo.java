package net.estinet.gFeatures.Feature.Bedwars.MapsSpec;

import net.estinet.gFeatures.Feature.Bedwars.Basic;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;


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

public class MapTwo {

	public static List<Location> planespawn = new ArrayList<>();
	public static List<Location> towerspawn = new ArrayList<>();
	public static Location spectatespawn;
	public static Location flag;

	public void justDoIt(){
		planespawn.add(new Location(Bukkit.getWorld("Gliders2"), -662.5, 220.5, 881.5));

		towerspawn.add(new Location(Bukkit.getWorld("Gliders2"), -560.5, 61.5, -868.5));

		spectatespawn = new Location(Bukkit.getWorld("Gliders2"), -575.5, 135.5, 883.5);
		flag = new Location(Bukkit.getWorld("Gliders2"), -579.5, 49.5, 879.5);
		Basic.mapName = "LargeIsland";
		Basic.planespawn = planespawn;
		Basic.towerspawn = towerspawn;
		Basic.spectatespawn = spectatespawn;
		Basic.flag = flag;

	}
	public void reassign(){
		planespawn.add(new Location(Bukkit.getWorld("Gliders2"), -662.5, 220.5, 881.5));

		towerspawn.add(new Location(Bukkit.getWorld("Gliders2"), -560.5, 61.5, 868.5));

		spectatespawn = new Location(Bukkit.getWorld("Gliders2"), -575.5, 135.5, 883.5);
		flag = new Location(Bukkit.getWorld("Gliders2"), -579.5, 49.5, 879.5);

		Basic.mapName = "Gliders2";
		Basic.planespawn = planespawn;
		Basic.towerspawn = towerspawn;
		Basic.spectatespawn = spectatespawn;
		Basic.flag = flag;
	}
}
