package net.estinet.gFeatures.Feature.CTF.MapsSpec;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.Feature.CTF.Maps;

public class Spec {
	MapTwo mt = new MapTwo();
	MapOne mo = new MapOne();
	public void direction(Maps map){
		switch(map){
		case One: 
			Bukkit.getLogger().info("[CTF] Map one selected!");
			mo.justDoIt();
			break;
		case Two:
			Bukkit.getLogger().info("[CTF] Map Two selected!");
			mt.justDoIt();
			break;
		default:
			Bukkit.getLogger().info("Wat");
		}
	}
}
