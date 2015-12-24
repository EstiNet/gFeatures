package net.genesishub.gFeatures.Feature.gHub;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PreventFall {
	public void check(){
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.getLocation().getY() < 110){
				p.teleport(new Location(Bukkit.getWorld("GenesisHub"), -72.5, 236, -10.5));
			}
		}
	}
}
