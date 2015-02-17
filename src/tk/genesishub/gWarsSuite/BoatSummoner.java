package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BoatSummoner {
	public void BoatSummon(Player p){
		boolean bool = false;
		World world = Bukkit.getServer().getWorld("gWars");
		Location location = p.getLocation();
		int x = (int) location.getX();
		int z = (int) location.getZ();
		Location[] orange = {new Location(world, 414, 4, 218), new Location(world, 414, 4, 220), new Location(world, 414, 4, 226), new Location(world, 414, 4, 231)};
		Location[] blue = {new Location(world, 577, 4, 112), new Location(world, 577, 4, 108),  new Location(world, 577, 4, 109), new Location(world, 577, 4, 112)};
		Location[] island = {new Location(world, 545, 4, 441), new Location(world, 552, 4, 440), new Location(world, 559, 4, 441), new Location(world, 566, 4, 441)};
		for(int i = 409; i<=420; i++){
			for(int iter = 212; iter<=238; iter++){
				if(x == i && z == iter){
					int rand = (int) Math.ceil(Math.random()*4);
						world.spawnEntity(orange[rand], EntityType.BOAT);
						bool = true;
						p.sendMessage(ChatColor.BOLD+"A boat has been summoned near your area!");
						p.sendMessage(ChatColor.BOLD+"Please wait 10 seconds before summoning another vehicle.");
					}
				}
			}
			for(int i = 570; i<=582; i++){
				for(int iter = 93; iter<=120; iter++){
					if(x == i && z == iter){
						int rand = (int) Math.ceil(Math.random()*4);
							world.spawnEntity(blue[rand], EntityType.BOAT);
							bool = true;
							p.sendMessage(ChatColor.BOLD+"A boat has been summoned near your area!");
							p.sendMessage(ChatColor.BOLD+"Please wait 10 seconds before summoning another vehicle.");
						}
					}
				}
			for(int i = 537; i<=576; i++){
				for(int iter = 433; iter<=443; iter++){
					if(x == i && z == iter){
						int rand = (int) Math.ceil(Math.random()*4);
							world.spawnEntity(island[rand], EntityType.BOAT);
							bool = true;
							p.sendMessage(ChatColor.BOLD+"A boat has been summoned near your area!");
							p.sendMessage(ChatColor.BOLD+"Please wait 10 seconds before summoning another vehicle.");
						}
					}
				}
		if(bool == false){
			p.sendMessage(ChatColor.BOLD+"Get closer to the docks!");
			p.sendMessage(ChatColor.BOLD+"Please wait 10 seconds before summoning another vehicle.");
		}
	}
}
