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
	
	public static Location teleport1 = new Location(Bukkit.getServer().getWorld("gWars"), -449, 75.0, 390.0);
	public static Location teleport2 = new Location(Bukkit.getServer().getWorld("gWars"), -353, 90.0, 303.0);
	public static Location teleport3 = new Location(Bukkit.getServer().getWorld("gWars"), -290.0, 109.0, 222.0);
	public static Location teleport4 = new Location(Bukkit.getServer().getWorld("gWars"), -213.0, 110.0, -196.0);
	public static Location teleport5 = new Location(Bukkit.getServer().getWorld("gWars"), -78.0, 84.0, 174);
	public static Location teleport6 = new Location(Bukkit.getServer().getWorld("gWars"), 2.0, 88.0, 153);
	public static Location teleport7 = new Location(Bukkit.getServer().getWorld("gWars"), 56.0, 94.0, 110);
	public static Location teleport8 = new Location(Bukkit.getServer().getWorld("gWars"), 81.0, 105.0, -17);
	public static Location teleport9 = new Location(Bukkit.getServer().getWorld("gWars"), 253.0, 105.0, -69);
	public static Location teleport10 = new Location(Bukkit.getServer().getWorld("gWars"), 338.0, 80.0, -122);
	public static Location teleport11 = new Location(Bukkit.getServer().getWorld("gWars"), 365.0, 80.0, -206);
	public static Location teleport12 = new Location(Bukkit.getServer().getWorld("gWars"), 427.0, 112.0, -174);
	public static Location teleport13 = new Location(Bukkit.getServer().getWorld("gWars"), 548.0, 84.0, -158);
	public static Location teleport14 = new Location(Bukkit.getServer().getWorld("gWars"), 643.0, 84.0, -103);
	public static Location teleport15 = new Location(Bukkit.getServer().getWorld("gWars"), 713.0, 122.0, 109);
	public static Location teleport16 = new Location(Bukkit.getServer().getWorld("gWars"), 554.0, 101.0, 279);
	public static Location teleport17 = new Location(Bukkit.getServer().getWorld("gWars"), 233.0, 101.0, 329);
	
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
