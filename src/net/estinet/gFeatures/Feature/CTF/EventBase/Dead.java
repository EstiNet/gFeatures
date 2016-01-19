package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Respawn;

public class Dead {
	Respawn r = new Respawn();
	public void init(Player p){
		if(Basic.blueflagger.getName().equals(p.getName())){
			Action.sendAllTitle(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + " has died!", ChatColor.GOLD + "" + ChatColor.BOLD + "The orange flag has been returned.", 20, 40, 20);
			Basic.blueflagger = null;
		}
		else if(Basic.orangeflagger.getName().equals(p.getName())){
			Action.sendAllTitle(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + p.getName() + " has died!", ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "The blue flag has been returned.", 20, 40, 20);
			Basic.orangeflagger = null;
		}
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
