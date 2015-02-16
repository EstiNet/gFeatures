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
		Location[] blue = {new Location(world, 562, 4, 132), new Location(world, 564, 4, 132),  new Location(world, 566, 4, 132), new Location(world, 568, 4, 132)};
		Location[] island = {new Location(world, 550, 8, 415), new Location(world, 560, 8, 428)};
		for(int i = 409; i<=420; i++){
			for(int iter = 212; iter<=238; iter++){
				if(x == i && z == iter){
					int rand = (int) Math.ceil(Math.random()*4);
						world.spawnEntity(orange[rand], EntityType.MINECART);
						bool = true;
						p.sendMessage(ChatColor.BOLD+"A boat has been summoned near your area!");
						p.sendMessage(ChatColor.BOLD+"Please wait 10 seconds before summoning another vehicle.");
					}
				}
			}
			for(int i = 560; i<=570; i++){
				for(int iter = 128; iter<=167; iter++){
					if(x == i && z == iter){
						int rand = (int) Math.ceil(Math.random()*4);
							world.spawnEntity(blue[rand], EntityType.MINECART);
							bool = true;
							p.sendMessage(ChatColor.BOLD+"A boat has been summoned near your area!");
							p.sendMessage(ChatColor.BOLD+"Please wait 10 seconds before summoning another vehicle.");
						}
					}
				}
			for(int i = 565; i<=547; i++){
				for(int iter = 427; iter<=430; iter++){
					if(x == i && z == iter){
						int rand = (int) Math.ceil(Math.random()*2);
							world.spawnEntity(island[rand], EntityType.MINECART);
							bool = true;
							p.sendMessage(ChatColor.BOLD+"A boat has been summoned near your area!");
							p.sendMessage(ChatColor.BOLD+"Please wait 10 seconds before summoning another vehicle.");
						}
					}
				}
		if(bool == false){
			p.sendMessage(ChatColor.BOLD+"Get closer to the docks!");
			p.sendMessage(ChatColor.BOLD+"Please wait 30 seconds before summoning another vehicle.");
		}
	}
}
