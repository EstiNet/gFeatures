package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.CTF.Basic;

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

public class MapTwo extends CTFMap{

	public MapTwo() {
		super.directory = new File("plugins/gFeatures/CTF/CTF2");
		super.mapName = "Wild West";
	}

	public void setPoints() {
		Basic.mapName = super.mapName;
		Basic.orangespawn = new Location(Bukkit.getWorld("CTF"), 1427.5, 45.5, 1005.5);
		Basic.bluespawn = new Location(Bukkit.getWorld("CTF"), 1206.5, 45.5, 785.5);
		Basic.orangeflag = new Location(Bukkit.getWorld("CTF"), 1436.5, 26.5, 997.5);
		Basic.blueflag = new Location(Bukkit.getWorld("CTF"), 1197.5, 26.5, 795.5);
		Basic.spectatespawn = new Location(Bukkit.getWorld("CTF"), 1321, 55, 876);
		Basic.orangeafterspawn = new Location(Bukkit.getWorld("CTF"), 1427, 26, 1012);
		Basic.blueafterspawn = new Location(Bukkit.getWorld("CTF"), 1206, 26, 780);
	}
}
