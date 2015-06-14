package net.genesishub.gFeatures.Feature.gHub;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;

public class Enable {
	public void onEnable(){
		Bukkit.getLogger().info("[gHub] gHub is enabled! Hi!");
		Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
	}
}
