package net.estinet.gFeatures.Feature.gFactions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

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

public class Blaze {
	public static World world = Bukkit.getWorld("Factions1.8.3");
	public static Location sniper = new Location(Bukkit.getWorld("Factions1.8.3"), -261.5, 96, 127.5);
	public static Location shotgun = new Location(Bukkit.getWorld("Factions1.8.3"), -257.5, 97, 179.5);
	public static Location autorifle = new Location(Bukkit.getWorld("Factions1.8.3"), -222.5, 97, 153.5);
	public static UUID snipers;
	public static UUID shotguns;
	public static UUID autorifles;
	public static List<String> invtrigger = new ArrayList<>();
}
