package net.estinet.gFeatures.Feature.gFactions;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Blaze {
	public static World world = Bukkit.getWorld("Factions1.8.3");
	public static Location sniper = new Location(Bukkit.getWorld("Factions1.8.3"), -261.5, 96, 127.5);
	public static Location shotgun = new Location(Bukkit.getWorld("Factions1.8.3"), -257.5, 97, 179.5);
	public static Location autorifle = new Location(Bukkit.getWorld("Factions1.8.3"), -222.5, 97, 153.5);
	public static UUID snipers;
	public static UUID shotguns;
	public static UUID autorifles;
}
