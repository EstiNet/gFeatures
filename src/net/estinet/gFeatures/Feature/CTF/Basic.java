package net.estinet.gFeatures.Feature.CTF;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Basic {
	public static Location orangespawn;
	public static Location bluespawn;
	public static Location spectatespawn;
	public static Location waitspawn = new Location(Bukkit.getWorld("MinigameSpawn"), 76.5, 96.5, 91.5);
	public static int orangeflags = 0;
	public static int blueflags = 0;
	public static HashMap<UUID, Integer> kills = new HashMap<>();
	public static HashMap<UUID, Integer> deaths = new HashMap<>();
	public static HashMap<UUID, Integer> flagcaptures = new HashMap<>();
	public static HashMap<UUID, PlayerMode> modes = new HashMap<>();
	public static HashMap<UUID, Team> teams = new HashMap<>();
	public static Mode mode = Mode.WAITING;
}
