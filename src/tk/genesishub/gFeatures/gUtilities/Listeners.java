package tk.genesishub.gFeatures.gUtilities;

import org.bukkit.Bukkit;

public class Listeners {
	public void onEnable(){
		Bukkit.getLogger().info("gUtilities enabled! Make sure you turn on features!");
		Enabler e = new Enabler();
		e.Start();
	}
	public void onDisable(){
		Bukkit.getLogger().info("gUtilities disabled!");
	}
}
