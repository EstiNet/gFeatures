package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.CTF.Basic;

public class MapOne {
	public static Location orangespawn = new Location(Bukkit.getWorld("CTF"), -167.5, 29.5, 45.5);
	public static Location bluespawn = new Location(Bukkit.getWorld("CTF"), 105.5, 28.5, 13.5);
	public static Location orangeflag = new Location(Bukkit.getWorld("CTF"), -175.5, 26.5, 45.5);
	public static Location blueflag = new Location(Bukkit.getWorld("CTF"), 113.5, 25.5, 13.5);
	public static Location spectatespawn = new Location(Bukkit.getWorld("CTF"), -27, 35, 2);
	public static Location orangeafterspawn = new Location(Bukkit.getWorld("CTF"), -171, 20.5, 45);
	public static Location blueafterspawn = new Location(Bukkit.getWorld("CTF"), 110, 18.5, 13);
	
	File f = new File("plugins/gFeatures/CTF/CTF1");
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
		
		Basic.orangespawn = orangespawn;
		Basic.bluespawn = bluespawn;
		Basic.orangeflag = orangeflag;
		Basic.blueflag = blueflag;
		Basic.spectatespawn = spectatespawn;
		Basic.orangeafterspawn = orangeafterspawn;
		Basic.blueafterspawn = blueafterspawn;
	}
}
