package net.estinet.gFeatures.Feature.gMusic;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Music {
	public void sendMusic(Player p, String codename, int volume, String artist, String songname, String custommessage){
		p.playSound(p.getLocation(), codename, volume, 1);
		if(!custommessage.equals("") && !custommessage.equals(null)){
			p.sendMessage(custommessage);
		}
		else{
			p.sendMessage(ChatColor.BOLD + "-----" + ChatColor.GOLD + "" + ChatColor.BOLD + "Music" + ChatColor.WHITE + ChatColor.BOLD +  "-----");
			p.sendMessage(ChatColor.AQUA + "Song name: " + songname);
			p.sendMessage(ChatColor.AQUA + "Artist: " + artist);
			p.sendMessage(ChatColor.BOLD + "---------------");
		}
	}
}
