package tk.genesishub.gFeatures.gWarsSuite;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CompassTracker {
	TeamManager tm = new TeamManager();
	public void set(Player player, Location loc){
		player.setCompassTarget(loc);
	}
	public void onCompassTracker(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if((e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.COMPASS){
            p.setCompassTarget(getNearest(p, 1000000.0).getLocation());
        }
    }
	public Player getNearest(Player p, Double range) {
        double distance = Double.POSITIVE_INFINITY; // To make sure the first
                                                    // player checked is closest
        Player target = p;
        for (Entity e : p.getNearbyEntities(range, range, range)) {
            if (!(e instanceof Player))
                continue;
            double distanceto = p.getLocation().distance(e.getLocation());
            if (distanceto > distance)
                continue;
            distance = distanceto;
            if(tm.getTeam(((Player) e).getName()).equals(ChatColor.BLUE + "blue") && tm.getTeam(p.getName()).equals(ChatColor.GOLD + "orange")){
            	target = (Player) e;
            }
            else if(tm.getTeam(((Player) e).getName()).equals(ChatColor.BLUE + "orange") && tm.getTeam(p.getName()).equals(ChatColor.GOLD + "blue")){
            	target = (Player) e;
            }
        }
        return target;
    }
}	
