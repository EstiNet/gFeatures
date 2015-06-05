package net.genesishub.gFeatures.Feature.gWarsSuite;

import java.util.HashMap;

import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Point;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Team;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Constants {
	public final static World world = Bukkit.getServer().getWorld("gWars");
	
	public final static Location spawnonjoin = new Location(Bukkit.getServer().getWorld("gWars"), 350.3, 103.0, -59.3);
	public final static Location multiplayergunselection = new Location(Bukkit.getServer().getWorld("gWars"), 250.0, 103.0, -59.0); //TODO
	public final static Location multiplayerorangeteamlook = new Location(Bukkit.getServer().getWorld("gWars"), 636.0, 91.0, -96.0); //TODO
	public static HashMap<Point, Team> multiplayerpossession = new HashMap<>();
	public static HashMap<Player, gWarsMode> mode = new HashMap<>();
	public static HashMap<Player, String> loredump = new HashMap<>();
	public static HashMap<Player, Location> spawndump = new HashMap<>();
	
	public final static Location orangebase = new Location(world, 666, 66, -91);
	public final static Location bluebase = new Location(world , 59, 66, 224);
	
	public final static Point innisfilhighway = new Point("Innisfil Highway", new Location(world, 42, 60, 80), new Location(world, 44, 60, 78), new Location(world, 43, 61, 80));
	public final static Point kloynehighway = new Point("Kloyne Highway", new Location(world, 514, 60, -74), new Location(world, 512, 60, -76), new Location(world, 514, 61, -75));
	public final static Point bridge = new Point("Bridge", new Location(world, 42, 60, 80), new Location(world, 44, 60, 78), new Location(world, 514, 61, -75)); //TODO location
}
