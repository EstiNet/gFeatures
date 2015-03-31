package tk.genesishub.gFeatures.HideAndSeek;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;

import tk.genesishub.gFeatures.API.MinigameBase.Arena;
import tk.genesishub.gFeatures.API.MinigameBase.Game;
import tk.genesishub.gFeatures.API.MinigameBase.Teams;

public class Listeners {
	Teams hider;
	Teams finder;
	Arena currentarena;
	Game hideandseek;
	public void onEnable(){
		Bukkit.getLogger().info("HideAndSeek enabled. What's up?");
		hider = new Teams(ChatColor.DARK_AQUA + "Hider");
		finder = new Teams(ChatColor.GRAY + "Finder");
		hideandseek = new Game("HideAndSeek");
	}
	public void onDisable(){
		Bukkit.getLogger().info("HideAndSeek disabled. Bye!");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		
	}
}
