package tk.genesishub.gFeatures.gWarsSuite;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class TotallyNotFlyingBoats {
	public void Initialize(PlayerInteractEvent event){
		 try{
	       	 Player p = event.getPlayer();
	       	 if(p.getVehicle() instanceof Boat){
	       		 if(event.getAction() == Action.RIGHT_CLICK_AIR){
	       			 int v = 5;
	       			    final Vector direction = p.getEyeLocation().getDirection().multiply(v);
	       			    Arrow tnt = p.getWorld().spawn(p.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), Arrow.class);
	       			    tnt.setVelocity(direction);
	       		 }
	       		 if(event.getAction() == Action.LEFT_CLICK_AIR){
	       			 int v = 2;
	    			    final Vector direction = p.getEyeLocation().getDirection().multiply(v);
	    			    TNTPrimed tnt = p.getWorld().spawn(p.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), TNTPrimed.class);
	    			    tnt.setVelocity(direction);
	       		 }
	       	 }
	       	 return;
	       	 }
	       	 catch(Exception e){
	       		 }
	}
}
