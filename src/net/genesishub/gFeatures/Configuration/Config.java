package net.genesishub.gFeatures.Configuration;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Config {
	public void createFile(String path, String message){
		File f = new File(path);
		if(!(f.isDirectory())){
			f.mkdir();
			Bukkit.getLogger().info(ChatColor.GOLD + "[gFeatures] " + message);
			return;
		}
		else{
			return;
		}
	}
}
