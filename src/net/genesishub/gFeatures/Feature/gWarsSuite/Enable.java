package net.genesishub.gFeatures.Feature.gWarsSuite;

import org.bukkit.Bukkit;

import net.genesishub.gFeatures.Basic;

public class Enable {
	public static void onEnable(){
		Bukkit.getLogger().info("[gFeatures-gWarsSuite]gWarsSuite enabled! Running core version " + Basic.getFeature("gWarsSuite").getVersion() + "!");
	}
}
