package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class TrailLoop {
	public void init(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				for(Player p : Bukkit.getOnlinePlayers()){
					try{
						switch(Shop.playerTrail.get(p.getUniqueId())){
						case "NONE":
							continue;
						case "FIRE":
							//ParticleEffect.FLAME.display(0, 0, 0, 3, 1, p.getLocation(), 100);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.FLAME, 34);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.FLAME, 28);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.LAVA_POP, 31);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.LAVADRIP, 32);
							break;
						case "WATER":
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 34);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 28);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 34);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 28);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.WATERDRIP, 31);
							break;
						case "GRAY":
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.CLOUD, 34);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.CLOUD, 28, 7);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 31, 7);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 31, 21);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 31, 15);
							break;
						case "MUSIC":
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.NOTE, 34);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.CRIT, 28, 7);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.NOTE, 31, 7);
							break;
						case "RAINBOW":
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 34);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 28);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 32);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 29);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 44);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 24);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 31);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 31);
							Bukkit.getWorld(p.getWorld().getName()).playEffect(p.getLocation(), Effect.COLOURED_DUST, 31);
							break;
						}
					}
					catch(NullPointerException e){}//in case
				}
			}
		}, 3L, 3L);
	}
}
