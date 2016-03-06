package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

public class CompassLoop {
	static Player target;
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
				Player playerget = getNearest(p, 50.0);
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
        target = p;
        for (Entity e : p.getNearbyEntities(range, range, range)) {
            if (!(e instanceof Player)){
                continue;
            }
            double distanceto = p.getLocation().distance(e.getLocation());
            if (distanceto > distance){
                continue;
            }
            distance = distanceto;
            if(stats.getTeam((Player) e).equals(Team.BLUE) && stats.getTeam(p).equals(Team.ORANGE)){
            	target = (Player) e;
            }
            else if(stats.getTeam((Player) e).equals(Team.ORANGE) && stats.getTeam(p).equals(Team.BLUE)){
            	target = (Player) e;
            }
        }
        return target;
    }
}
