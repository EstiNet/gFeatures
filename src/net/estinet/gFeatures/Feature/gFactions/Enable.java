package net.estinet.gFeatures.Feature.gFactions;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.Basic;

public class Enable {
	public void plzenable(){
		Bukkit.getLogger().info("gFactions initialized! Yay!");
		Basic.addPlayerSection("gFactions", "");
		Basic.addPlayerSection("gFactions.Tier", "none");
		Basic.addPlayerSection("gFactions.TierRank", "0");
	}
}
