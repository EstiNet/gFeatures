package net.estinet.gFeatures.Feature.gHub;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class Stacker {
	public void event(Player p){
		if(Basis.isInStacker(p.getName())){
			Basis.removeStacker(p.getName());
			p.sendMessage(ChatColor.GOLD + "[" + ChatColor.AQUA + "EstiNet" + ChatColor.GOLD + "] " + ChatColor.RED + "Your stacker is now off!");
		}
		else{
			Basis.addStacker(p.getName());
			p.sendMessage(ChatColor.GOLD + "[" + ChatColor.AQUA + "EstiNet" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Your stacker is now on!");
		}
	}
	  public Player checkPassenger(Player p)
	  {
	    if ((p.getPassenger() != null) && ((p.getPassenger() instanceof Player))) {
	      return (Player)p.getPassenger();
	    }
	    return (Player)p.getPassenger();
	  }
	  
	  public Vector giveVector(Location loc){
	    double pitch = (loc.getPitch() + 90.0F) * 3.141592653589793D / 180.0D;
	    double yaw = (loc.getYaw() + 90.0F) * 3.141592653589793D / 180.0D;
	    
	    double x = Math.sin(pitch) * Math.cos(yaw);
	    double y = Math.sin(pitch) * Math.sin(yaw);
	    double z = Math.cos(pitch);
	    
	    Vector vector = new Vector(x, z, y);
	    
	    return vector;
	  }
	  public void onEntityInteract(PlayerInteractEntityEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((e.getRightClicked() instanceof Player)) {
	        Player pl = (Player)e.getRightClicked();
	          if (Basis.isInStacker(p.getName())) {
	            if (Basis.isInStacker(pl.getName())){
	                p.setPassenger(pl);
	            }
	            else{
	            	p.sendMessage(ChatColor.GOLD + "[" + ChatColor.AQUA + "EstiNet" + ChatColor.GOLD + "] " + ChatColor.GREEN + "The player isn't playing stacker right now!");
	            }
	          }
	        }
	        else{
	          p.sendMessage(ChatColor.GOLD + "[" + ChatColor.AQUA + "EstiNet" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Your stacker needs to be on!");
	        }
	  }
	  public void onInteract(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	      if ((p.getPassenger() instanceof Player)) {
	          Player pass = (Player)p.getPassenger();
	            pass.leaveVehicle();
	            Location loc = p.getLocation();
	            int strength = 5;
	            if (strength > 0) {
	              pass.setVelocity(giveVector(loc).multiply(strength));
	            } else if (strength < -1) {
	              pass.teleport(loc);
	            }
	      }
	  }
}
