package tk.genesishub.gFeatures.gScore;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

import com.earth2me.essentials.api.UserDoesNotExistException;

public class Listeners {
	public void onEnable(){
		Bukkit.getLogger().info("gScore is enabled! Stuff will happen!");
	}
	public void onDisable(){
		Bukkit.getLogger().info("gScore is disabled! :(");
	}
	public void onPlayerJoin(PlayerJoinEvent event) throws IllegalArgumentException, IllegalStateException, UserDoesNotExistException{
		Scored s = new Scored();
		event.getPlayer().setScoreboard(s.Initialize(event.getPlayer()));
	}
}
