package net.genesishub.gFeatures.API.Minigame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Resource{

	public void broadcast(String str, String gamename){
		Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[" +  gamename + "]" + ChatColor.BOLD + "" + ChatColor.GOLD + str);
	}
	
}
