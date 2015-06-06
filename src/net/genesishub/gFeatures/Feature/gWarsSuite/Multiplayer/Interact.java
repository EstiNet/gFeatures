package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact {
	public void initialize(PlayerInteractEvent event){
		World world = Bukkit.getServer().getWorld("gWars");
		if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getServer().getWorld("gWars"), 657, 61, -56))){//Orange
			int random = (int) Math.ceil(Math.random() * 4);
			switch(random){
			case 1:
				world.spawnEntity(new Location(world, 651, 61, -54), EntityType.MINECART);
				break;
			}
		}
		else if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getServer().getWorld("gWars"), 657, 61, -56))){//Blue
			
		}
	}
}
