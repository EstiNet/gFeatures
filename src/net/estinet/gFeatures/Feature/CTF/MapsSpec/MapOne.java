package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Feature.CTF.Basic;

public class MapOne {
	File f = new File("plugins/gFeatures/CTF/CTF1");
	File fz = new File("./CTF");
	File fl = new File("plugins/gFeatures/CTF/MinigameSpawn");
	File flz = new File("./MinigameSpawn");
	public void justDoIt(){
		fz.delete();
		try {
			FileUtils.copyDirectory(f, fz);
			FileUtils.copyDirectory(fl, flz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Basic.orangespawn = new Location(Bukkit.getWorld("CTF"), -167.5, 29.5, 45.5);
		Basic.bluespawn = new Location(Bukkit.getWorld("CTF"), 105.5, 28.5, 13.5);
		Basic.orangeflag = new Location(Bukkit.getWorld("CTF"), -175.5, 26.5, 45.5);
		Basic.blueflag = new Location(Bukkit.getWorld("CTF"), 113.5, 25.5, 13.5);
		Basic.spectatespawn = new Location(Bukkit.getWorld("CTF"), -27, 35, 2);
	}
}
