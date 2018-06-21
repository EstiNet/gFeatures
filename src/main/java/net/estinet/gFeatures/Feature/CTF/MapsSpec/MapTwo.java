package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import java.io.File;
import java.io.IOException;

import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.CTF.Basic;

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

public class MapTwo implements CTFMap{
	File f = new File("plugins/gFeatures/CTF/CTF2");
	File fz = new File("./CTF");
	File fl = new File("plugins/gFeatures/CTF/MinigameSpawn");
	File flz = new File("./MinigameSpawn");

	public void justDoIt(){
		fz.delete();
		flz.delete();
		try {
			FileUtils.copyDirectory(f, fz);
			FileUtils.copyDirectory(fl, flz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ClioteSky.getInstance().sendAsync(ClioteSky.stringToBytes("Wild West"), "mgmap", "Bungee");
		setPoints();
	}
	public void setPoints() {
		Location orangespawn = new Location(Bukkit.getWorld("CTF"), 1206.5, 45.5, 785.5);
		Location bluespawn = new Location(Bukkit.getWorld("CTF"), 1427.5, 45.5, 1005.5);
		Location orangeflag = new Location(Bukkit.getWorld("CTF"), 1436.5, 26.5, 996.5);
		Location blueflag = new Location(Bukkit.getWorld("CTF"), 113.5, 25.5, 13.5);
		Location spectatespawn = new Location(Bukkit.getWorld("CTF"), 1321, 55, 876);
		Location orangeafterspawn = new Location(Bukkit.getWorld("CTF"), 1427, 26, 1012);
		Location blueafterspawn = new Location(Bukkit.getWorld("CTF"), 1206, 26, 780);
		Basic.mapName = "Wild West";
		Basic.orangespawn = orangespawn;
		Basic.bluespawn = bluespawn;
		Basic.orangeflag = orangeflag;
		Basic.blueflag = blueflag;
		Basic.spectatespawn = spectatespawn;
		Basic.orangeafterspawn = orangeafterspawn;
		Basic.blueafterspawn = blueafterspawn;
	}
}
