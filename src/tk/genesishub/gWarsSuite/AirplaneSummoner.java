package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class AirplaneSummoner {
	public void AirplaneSummon(Player p){
		boolean bool = false;
		World world = Bukkit.getServer().getWorld("gWars");
		Location location = p.getLocation();
		int x = (int) location.getX();
		int z = (int) location.getZ();
		Bukkit.getLogger().info("X: " + x + " Z: " + z);
		Location[] orange = {new Location(world, 425, 4, 200), new Location(world, 423, 4, 200), new Location(world, 427, 4, 200), new Location(world, 429, 4, 200)};
		Location[] blue = {new Location(world, 562, 4, 132), new Location(world, 564, 4, 132),  new Location(world, 566, 4, 132), new Location(world, 568, 4, 132)};
		for(int i = 421; i<=433; i++){
			for(int iter = 164; iter<=204; iter++){
				Bukkit.getLogger().info(i + " and " + iter);
				if(x == i && z == iter){
					Bukkit.getLogger().info("HI");
					int rand = (int) Math.ceil(Math.random()*4);
						world.spawnEntity(orange[rand], EntityType.MINECART);
						Bukkit.getLogger().info(i + " and " + iter);
						bool = true;
						p.sendMessage(ChatColor.BOLD+"An airplane has been summoned to your area!");
						p.sendMessage(ChatColor.BOLD+"Please wait 30 seconds before summoning another aircraft.");
					}
				}
			}
			for(int i = 560; i<=570; i++){
				for(int iter = 128; iter<=167; iter++){
					Bukkit.getLogger().info(i + " and " + iter);
					if(x == i && z == iter){
						int rand = (int) Math.ceil(Math.random()*4);
							world.spawnEntity(blue[rand], EntityType.MINECART);
							Bukkit.getLogger().info(i + " and " + iter);
							bool = true;
							p.sendMessage(ChatColor.BOLD+"An airplane has been summoned to your area!");
							p.sendMessage(ChatColor.BOLD+"Please wait 30 seconds before summoning another aircraft.");
						}
					}
				}
			for(int i = 565; i<=547; i++){
				for(int iter = 427; iter<=430; iter++){
					Bukkit.getLogger().info(i + " and " + iter);
					if(x == i && z == iter){
						int rand = (int) Math.ceil(Math.random()*4);
							world.spawnEntity(blue[rand], EntityType.MINECART);
							bool = true;
							p.sendMessage(ChatColor.BOLD+"An airplane has been summoned to your area!");
							p.sendMessage(ChatColor.BOLD+"Please wait 30 seconds before summoning another aircraft.");
						}
					}
				}
		if(bool == false){
			p.sendMessage(ChatColor.BOLD+"Get closer to an airfield!");
			p.sendMessage(ChatColor.BOLD+"Please wait 30 seconds before summoning another aircraft.");
		}
	}
}
