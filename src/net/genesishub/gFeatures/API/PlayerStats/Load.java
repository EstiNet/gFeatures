package net.genesishub.gFeatures.API.PlayerStats;

import java.io.File;

import net.genesishub.gFeatures.Configuration.Config;

public class Load {
	File f = new File("plugins/gFeatures/Players");
	public void load(){
		Config config = new Config();
		config.createDirectory("plugins/gFeatures/Players", "Players directory created!");
		for(File file : f.listFiles()){
			
		}
	}
}
