package net.genesishub.gFeatures.Feature.Statistics;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.API.PlayerStats.gPlayer;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHub {
	public void onPlayerJoin(PlayerJoinEvent event){
		gPlayer player = Basic.getgPlayer(event.getPlayer().getName());
		String value = Basic.getgPlayer(event.getPlayer().getUniqueId().toString()).getValue("Statistics.LoginCount");
		int count = Integer.parseInt(value);
		String finalvalue = Integer.toString(count += 1);
		Bukkit.getLogger().info(finalvalue);
		player.setValue("Statistics.LoginCount", finalvalue);
		Bukkit.getLogger().info(player.getValue("Statistics.LoginCount"));//TODO
		Basic.setgPlayer(Basic.getgPlayer(event.getPlayer().getUniqueId().toString()), player);
	}
}
