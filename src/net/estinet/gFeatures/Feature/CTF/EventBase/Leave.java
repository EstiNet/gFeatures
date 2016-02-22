package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Mode;

public class Leave {
	public void init(PlayerQuitEvent event){
		Basic.modes.remove(event.getPlayer().getUniqueId());
		Basic.kills.remove(event.getPlayer().getUniqueId());
		Basic.deaths.remove(event.getPlayer().getUniqueId());
		Basic.flagcaptures.remove(event.getPlayer().getUniqueId());
		if(Bukkit.getOnlinePlayers().size() == 1 && Basic.mode.equals(Mode.STARTED)){
			Bukkit.broadcastMessage(ChatColor.AQUA + "[CTF] " + ChatColor.WHITE + "Not enough players! Server restarting. :/");
			//Kick player off to hub with idro
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	        	public void run(){
	        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
	        	}
	        }, 60L);
		}
	}
}
