package net.genesishub.gFeatures.Feature.gWarsSuite;

import org.bukkit.Bukkit;

import net.genesishub.gFeatures.Basic;

public class Enable {
	public static void onEnable(){
		Bukkit.getLogger().info("[gFeatures-gWarsSuite]gWarsSuite enabled! Running core version " + Basic.getFeature("gWarsSuite").getVersion() + "!");
		Basic.addPlayerSection("gWars", "");
		Basic.addPlayerSection("gWars.Kills", "0");
		Basic.addPlayerSection("gWars.Deaths", "0");
	}
}
