package net.genesishub.gFeatures.Feature.CTF;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.genesishub.gFeatures.API.Minigame.Arena;
import net.genesishub.gFeatures.API.Minigame.Game;
import net.genesishub.gFeatures.API.Minigame.Resource;
import net.genesishub.gFeatures.API.Minigame.Teams;

public class Listeners {
	Teams Blue;
	Teams Orange;
	Arena currentarena;
	Game hideandseek;
	Resource resource;
	public void onEnable(){
		Bukkit.getLogger().info("CTF enabled. What's up?");
		Blue = new Teams(ChatColor.DARK_AQUA + "Blue");
		Orange = new Teams(ChatColor.GOLD + "Orange");
		hideandseek = new Game("CTF", 2);
		hideandseek.addTeam(Blue);
		hideandseek.addTeam(Orange);
		resource = new Resource();
	}
	public void onDisable(){
		Bukkit.getLogger().info("CTF disabled. Bye!");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		hideandseek.addPlayer(event.getPlayer());
	}
	public void onPlayerQuit(PlayerQuitEvent event){
		hideandseek.removePlayer(event.getPlayer());
	}
	public boolean checkStartTwo(){
		if(Blue.length() >= 1 && Orange.length() >= 1){
			return true;
		}
		return false;
	}
}
