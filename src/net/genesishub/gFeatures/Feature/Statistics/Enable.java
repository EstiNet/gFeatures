package net.genesishub.gFeatures.Feature.Statistics;

import net.genesishub.gFeatures.Basic;

import org.bukkit.Bukkit;

public class Enable {
	public static void onEnable(){
		Bukkit.getLogger().info("Statistics enabled! What's up?");
		Basic.addPlayerSection("Statistics", "");
		Basic.addPlayerSection("Statistics.LoginCount", "0");
		Basic.addPlayerSection("Statistics.LogoutCount", "0");
		Basic.addPlayerSection("Statistics.Deaths", "0");
		Basic.addPlayerSection("Statistics.Kills", "0");
	}
}
