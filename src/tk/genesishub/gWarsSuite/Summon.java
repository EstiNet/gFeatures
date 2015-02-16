package tk.genesishub.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Summon {
	public void Initialize(Player p, String value){
		if(value.equals("airplane")){
		AirplaneSummoner(p);
		}
		else if(value.equals("boat")){
			
		}
		}
	public void AirplaneSummoner(Player p){
		boolean bool = false;
		World world = Bukkit.getServer().getWorld("gWars");
		Location location = p.getLocation();
		Location[] orange = {new Location(world, 425, 4, 200), new Location(world, 423, 4, 200), new Location(world, 427, 4, 200), new Location(world, 429, 4, 200)};
		Location[] blue = {new Location(world, 562, 4, 132), new Location(world, 564, 4, 132),  new Location(world, 566, 4, 132), new Location(world, 568, 4, 132)};
		if(Constants.ot.contains(p.getName())){
		for(int i = 421; i<=433; i++){
			for(int iter = 164; iter<=204; iter++){
				if(location.getX() == i && location.getZ() == iter){
					int rand = (int) Math.ceil(Math.random()*4);
						world.spawnEntity(orange[rand], EntityType.MINECART);
						bool = true;
						p.sendMessage(ChatColor.BOLD+"An airplane has been summoned to your area!");
					}
				}
			}
		}
		else if(Constants.bt.contains(p.getName())){
			for(int i = 560; i<=570; i++){
				for(int iter = 128; iter<=167; iter++){
					if(location.getX() == i && location.getZ() == iter){
						int rand = (int) Math.ceil(Math.random()*4);
							world.spawnEntity(blue[rand], EntityType.MINECART);
							bool = true;
							p.sendMessage(ChatColor.BOLD+"An airplane has been summoned to your area!");
						}
					}
				}
		}
		if(bool == false){
			p.sendMessage(ChatColor.BOLD+"Get closer to an airfield!");
		}
	}
}
