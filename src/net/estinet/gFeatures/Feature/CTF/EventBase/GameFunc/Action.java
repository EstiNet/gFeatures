package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;

public class Action {
	static ActionAPI aapi = new ActionAPI();
	public static void sendAll(String message){
		for(Player p : Bukkit.getOnlinePlayers()){
			aapi.sendActionbar(p, message);
		}
	}
	public static void sendAllTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut){
		for(Player p : Bukkit.getOnlinePlayers()){
			aapi.sendTitles(p, fadeIn, stay, fadeOut, title, subtitle);
		}
	}
}
