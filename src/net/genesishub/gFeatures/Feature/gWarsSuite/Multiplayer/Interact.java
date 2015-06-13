package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact {
	public void initialize(PlayerInteractEvent event){
		try{
		World world = Bukkit.getServer().getWorld("gWars");
		if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getServer().getWorld("gWars"), 657, 61, -56))){//Orange
			int random = (int) Math.ceil(Math.random() * 4);
			event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Fighter Jet" + ChatColor.GRAY + ".");
			switch(random){
			case 1:
				world.spawnEntity(new Location(world, 651, 61, -54), EntityType.MINECART);
				break;
			case 2:
				world.spawnEntity(new Location(world, 655, 61, -54), EntityType.MINECART);
				break;
			case 3:
				world.spawnEntity(new Location(world, 659, 61, -54), EntityType.MINECART);
				break;
			case 4:
				world.spawnEntity(new Location(world, 663, 61, -54), EntityType.MINECART);
				break;
			}
			event.setCancelled(true);
		}
		else if(event.getClickedBlock().getLocation().equals(new Location(Bukkit.getServer().getWorld("gWars"), 24, 61, 216))){//Blue
			int random = (int) Math.ceil(Math.random() * 4);
			event.getPlayer().sendMessage(ChatColor.GRAY + "[Vehicle] Spawned a " + ChatColor.AQUA + "Fighter Jet" + ChatColor.GRAY + ".");
			switch(random){
			case 1:
				world.spawnEntity(new Location(world, 22, 61, 210), EntityType.MINECART);
				break;
			case 2:
				world.spawnEntity(new Location(world, 22, 61, 214), EntityType.MINECART);
				break;
			case 3:
				world.spawnEntity(new Location(world, 22, 61, 218), EntityType.MINECART);
				break;
			case 4:
				world.spawnEntity(new Location(world, 22, 61, 222), EntityType.MINECART);
				break;
			}
			event.setCancelled(true);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
