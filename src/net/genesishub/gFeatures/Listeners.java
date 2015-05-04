package net.genesishub.gFeatures;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Listeners extends JavaPlugin{
	public static final double version = 2.0;
	
	
	
	public void onEnable(){
		getLogger().info(ChatColor.AQUA + "_________________________________________________________________________");
		getLogger().info(ChatColor.GOLD + "[gFeatures] gFeatures enabled!");
		getLogger().info(ChatColor.GOLD + "[gFeatures] This gFeatures installation is running core: " + version);
		getLogger().info(ChatColor.GOLD + "[gFeatures] Turning on Features...");
		getLogger().info(ChatColor.GOLD + "[gFeatures] Complete!");
		getLogger().info(ChatColor.AQUA + "_________________________________________________________________________");
	}
	public void onDisable(){
		getLogger().info(ChatColor.AQUA + "_________________________________________________________________________");
		getLogger().info(ChatColor.GOLD + "[gFeatures] gFeatures disabled!");
		getLogger().info(ChatColor.GOLD + "[gFeatures] This gFeatures installation is running core: " + version);
		getLogger().info(ChatColor.GOLD + "[gFeatures] Turning off Features...");
		getLogger().info(ChatColor.GOLD + "[gFeatures] Complete!");
		getLogger().info(ChatColor.AQUA + "_________________________________________________________________________");
	}
}
