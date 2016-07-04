package net.estinet.gFeatures.Feature.Gliders.MapsSpec;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

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

	public static List<Location> planespawn = new ArrayList<>();
	public static List<Location> towerspawn = new ArrayList<>();
	public static Location spectatespawn;
	public static Location flag;

	public void justDoIt(){
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 769.5, 238.5, -563.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 751.5, 238.5, -563.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 734.5, 238.5, -568.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 481.5, 224.5, -566.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 497.5, 224.5, -565.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 490.5, 224.5, -565.5));

		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 581.5, 51.5, -563.5));
		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 590.5, 50.5, -510.5));
		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 614.5, 49.5, -540.5));
		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 619.5, 49.5, -583.5));
		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 585.5, 49.5, -592.5));

		spectatespawn = new Location(Bukkit.getWorld("Gliders1"), 596.5, 60.5, -564.5);
		flag = new Location(Bukkit.getWorld("Gliders1"), 596.5, 60.5, -564.5);

		Basic.mapName = "LargeIsland";
		Basic.planespawn = planespawn;
		Basic.towerspawn = towerspawn;
		Basic.spectatespawn = spectatespawn;
		Basic.flag = flag;
	}
	public void reassign(){
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 769.5, 238.5, -563.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 751.5, 238.5, -563.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 734.5, 238.5, -568.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 481.5, 224.5, -566.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 497.5, 224.5, -565.5));
		planespawn.add(new Location(Bukkit.getWorld("Gliders1"), 490.5, 224.5, -565.5));

		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 581.5, 51.5, -563.5));
		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 590.5, 50.5, -510.5));
		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 614.5, 49.5, -540.5));
		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 619.5, 49.5, -583.5));
		towerspawn.add(new Location(Bukkit.getWorld("Gliders1"), 585.5, 49.5, -592.5));

		spectatespawn = new Location(Bukkit.getWorld("Gliders1"), 596.5, 60.5, -564.5);
		flag = new Location(Bukkit.getWorld("Gliders1"), 596.5, 60.5, -564.5);

		Basic.mapName = "Gliders1";
		Basic.planespawn = planespawn;
		Basic.towerspawn = towerspawn;
		Basic.spectatespawn = spectatespawn;
		Basic.flag = flag;
	}
}
