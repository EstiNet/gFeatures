package tk.genesishub.gFeatures.HideAndSeek;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners {
	public void onEnable(){
		Bukkit.getLogger().info("HideAndSeek enabled. What's up?");
	}
	public void onDisable(){
		Bukkit.getLogger().info("HideAndSeek disabled. Bye!");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		
	}
}
