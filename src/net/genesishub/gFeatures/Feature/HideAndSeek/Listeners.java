package net.genesishub.gFeatures.Feature.HideAndSeek;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.genesishub.gFeatures.API.Minigame.Arena;
import net.genesishub.gFeatures.API.Minigame.Game;
import net.genesishub.gFeatures.API.Minigame.Resource;
import net.genesishub.gFeatures.API.Minigame.Teams;

public class Listeners {
	Teams hider;
	Teams finder;
	Arena currentarena;
	Game hideandseek;
	Resource resource;
	public void onEnable(){
		Bukkit.getLogger().info("HideAndSeek enabled. What's up?");
		hider = new Teams(ChatColor.DARK_AQUA + "Hider");
		finder = new Teams(ChatColor.GRAY + "Finder");
		hideandseek = new Game("HideAndSeek", 2);
		hideandseek.addTeam(hider);
		hideandseek.addTeam(finder);
		resource = new Resource();
	}
	public void onDisable(){
		Bukkit.getLogger().info("HideAndSeek disabled. Bye!");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		hideandseek.addPlayer(event.getPlayer());
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		hideandseek.removePlayer(event.getPlayer());
	}
	public boolean checkStartTwo(){
		if(hider.length() >= 1 && finder.length() >= 1){
			return true;
		}
		return false;
	}
}
