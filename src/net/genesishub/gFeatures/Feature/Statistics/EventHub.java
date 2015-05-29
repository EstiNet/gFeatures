package net.genesishub.gFeatures.Feature.Statistics;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.API.PlayerStats.gPlayer;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHub {
	public void onPlayerJoin(PlayerJoinEvent event){
		gPlayer player = Basic.getgPlayer(event.getPlayer().getName());
		String value = Basic.getgPlayer(event.getPlayer().getName()).getValue("Statistics.LoginCount");
		Bukkit.getLogger().info(value);
		int count = Integer.parseInt(value);
		String finalvalue = Integer.toString(count++);
		player.setValue("Statistics.LoginCount", finalvalue);
		Basic.setgPlayer(Basic.getgPlayer(event.getPlayer().getName()), player);
		Bukkit.getLogger().info("set");
	}
}
