package net.genesishub.gFeatures.API.Logger;

import org.bukkit.Bukkit;

import net.genesishub.gFeatures.Listeners;

public class Debug {
	public static void print(String str){
		if(Listeners.debug == true){
			Bukkit.getLogger().info("[Debug] " + str);
		} 
	}
}
