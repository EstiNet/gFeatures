package tk.genesishub.gFeatures.API.MinigameBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Resource {
	public void broadcast(String str){
		Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[GenesisHub]" + ChatColor.BOLD + "" + ChatColor.GOLD + str);
	}
	
}
