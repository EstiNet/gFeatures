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
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import net.estinet.gFeatures.Feature.gHub.Basis;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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
		for(Entity ent : Bukkit.getWorld("EstiNet").getEntities()){
			if(ent.getType().equals(EntityType.ENDER_CRYSTAL)){
				ent.remove();
			}
		}
		for(Location loc : Basis.crystals.keySet()){
			Bukkit.getWorld("EstiNet").spawn(loc, EnderCrystal.class);
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
