package tk.genesishub.gFeatures.API.MinigameBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Resource extends Game{
	public Resource(String name) {
		super(name);
	}

	public void broadcast(String str){
		Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[" +  super.gamename + "]" + ChatColor.BOLD + "" + ChatColor.GOLD + str);
	}
	
}
