package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CompassLoop {
	Statistics stats = new Statistics();
	public void updateAll(){
		for(Player p : BlueTeam.getList()){
			updatePlayer(p);
		}
		for(Player p : OrangeTeam.getList()){
			updatePlayer(p);
		}
	}
	public void updatePlayer(Player p){
		for(ItemStack st : p.getInventory().getContents()){
			try{
			if(st.getType().equals(Material.COMPASS)){
				p.getInventory().remove(st);
				Player playerget = getNearest(p, 30.0);
				p.setCompassTarget(playerget.getLocation());
				ItemMeta im = st.getItemMeta();
				im.setDisplayName(ChatColor.AQUA + "Compass: " + ChatColor.GOLD + "" + playerget.getName());
				st.setItemMeta(im);
				p.getInventory().addItem(st);
			}
			}
			catch(Exception e){
				continue;
			}
		}
	}
	public Player getNearest(Player p, Double range) {
        double distance = Double.POSITIVE_INFINITY; // To make sure the first
                                                    // player checked is closest
        Player target = p;
        for (Entity e : p.getNearbyEntities(range, range, range)) {
            if (!(e instanceof Player)){
                continue;
            }
            double distanceto = p.getLocation().distance(e.getLocation());
            if (distanceto > distance){
                continue;
            }
            distance = distanceto;
            if(stats.getTeam((Player) e).equals(Team.BLUE) && stats.getTeam((Player) e).equals(Team.ORANGE)){
            	target = (Player) e;
            }
            else if(stats.getTeam((Player) e).equals(Team.ORANGE) && stats.getTeam((Player) e).equals(Team.BLUE)){
            	target = (Player) e;
            }
        }
        return target;
    }
}
