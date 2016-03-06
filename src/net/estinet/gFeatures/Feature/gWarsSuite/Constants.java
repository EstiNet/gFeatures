package net.estinet.gFeatures.Feature.gWarsSuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.CaptureState;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Point;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Team;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

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

public class Constants {
	public static World world = Bukkit.getServer().getWorld("gWars");
	
	public static Location spawnonjoin = new Location(Bukkit.getServer().getWorld("gWars"), 350.3, 103.0, -59.3);
	public static Location multiplayergunselection = new Location(Bukkit.getServer().getWorld("gWars"), 250.0, 103.0, -59.0); //TODO
	public static Location multiplayerorangeteamlook = new Location(Bukkit.getServer().getWorld("gWars"), 636.0, 91.0, -96.0); //TODO
	public static HashMap<Point, Team> multiplayerpossession = new HashMap<>();
	public static HashMap<Player, gWarsMode> mode = new HashMap<>();
	public static HashMap<String, Location> spawndump = new HashMap<>();
	
	public static Location orangebase = new Location(world, 666, 66, -91);
	public static Location bluebase = new Location(world , 59, 66, 224);
	
	public static List<String> fighterjets = new ArrayList<>();
	public static List<String> bombers = new ArrayList<>();
	public static List<String> tank = new ArrayList<>();
	
	public static List<String> capturetrigger = new ArrayList<>();
	
	public static Point innisfilhighway = new Point("Innisfil Highway", new Location(world, 42, 60, 80), new Location(world, 45, 60, 77), new Location(world, 43, 61, 80), CaptureState.blue);
	public static Point kloynehighway = new Point("Kloyne Highway", new Location(world, 512, 60, -77), new Location(world, 515, 60, -74), new Location(world, 514, 61, -75), CaptureState.orange);
	public static Point bridge = new Point("Bridge", new Location(world, 351, 85, -142), new Location(world, 355, 85, -139), new Location(world, 353, 86, -141), CaptureState.white); 
}
