package net.estinet.gFeatures.Feature.gHub.crystal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;

import net.estinet.gFeatures.Feature.gHub.Basis;

public class Crystal {
	public void createFile(){
		File f = new File("plugins/gFeatures/gHub/Crystals");
		if(!f.isDirectory()){
			f.mkdir();
		}
		File[] listOfFiles = f.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				try {
					List<String> lines = getLines(listOfFiles[i]);
					MGServer mgs = new MGServer(lines.get(0), new Location(Bukkit.getWorld("EstiNet"), Double.parseDouble(lines.get(1)), Double.parseDouble(lines.get(2)), Double.parseDouble(lines.get(3))));
					Basis.crystals.put(mgs.getLocation(), mgs);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	public void initCrystal(){
		createFile();
		spawnCrystals();
	}
	public void spawnCrystals(){
		for(Location loc : Basis.crystals.keySet()){
			Bukkit.getWorld("CTF").spawn(loc, EnderCrystal.class);
		}
	}
	public List<String> getLines(File f) throws IOException{
		List<String> permissions = new ArrayList<>();
		FileInputStream is = new FileInputStream(f);
		Reader paramReader = new InputStreamReader(is);
		StringWriter writer = new StringWriter();
		IOUtils.copy(paramReader, writer);
		String theString = writer.toString();
		String[] lines = theString.split("\n");
		for(int i = 0; i < lines.length; i++){
			String perm = lines[i].replace("\r", "");
			permissions.add(perm);
		}
		return permissions;
	}
}
