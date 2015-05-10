package net.genesishub.gFeatures.Feature.gWarsSuite;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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
