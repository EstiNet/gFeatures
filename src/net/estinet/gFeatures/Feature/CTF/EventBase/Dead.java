package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Respawn;

public class Dead {
	Respawn r = new Respawn();
	public void init(Player p){
		p.setGameMode(GameMode.SPECTATOR);
		ActionAPI aapi = new ActionAPI();
		aapi.sendActionbar(p, ChatColor.RED + "Respawning in 3 seconds...");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		r.respawn(p);
        	}
        }, 60L);
	}
}
