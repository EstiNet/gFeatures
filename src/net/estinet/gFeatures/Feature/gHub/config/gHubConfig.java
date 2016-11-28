package net.estinet.gFeatures.Feature.gHub.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Feature.gHub.gHub;

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

public class gHubConfig {
	public void setup(){
		Config c = new Config();
		c.createDirectory("plugins/gFeatures/gHub", "Created gHub directory!");
		c.createFile("plugins/gFeatures/gHub/Config.yml", "Created gHub config!");
		File f = new File("plugins/gFeatures/gHub/spawn.txt");
		if(!f.exists()){
			c.createFile("plugins/gFeatures/gHub/spawn.txt", "Created spawn location!");
			BufferedWriter output;
			try {
				output = new BufferedWriter(new FileWriter(f, true));
				output.write("world");
				output.newLine();
				output.write("0");
				output.newLine();
				output.write("0");
				output.newLine();
				output.write("0");
				output.newLine();
				output.write("0");
				output.newLine();
				output.write("0");
				output.close();
			}
			catch(Exception e1){
				Bukkit.getLogger().info("UHOH");
			}
		}
	}
	public void retrieve(){
		try {
			List<String> list = getLines(new File("plugins/gFeatures/gHub/spawn.txt"));
			gHub.spawn = new Location(Bukkit.getWorld(list.get(0)), Double.parseDouble(list.get(1)), Double.parseDouble(list.get(2)), Double.parseDouble(list.get(3)), Float.parseFloat(list.get(4)), Float.parseFloat(list.get(5)));
		} catch (IOException e) {
			e.printStackTrace();
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
