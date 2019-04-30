package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class TrailLoop {
	public void init(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), () -> {
			for(Player p : Bukkit.getOnlinePlayers()){
				try{
					switch(Shop.playerTrail.get(p.getUniqueId())){
					case "NONE":
						continue;
					case "FIRE":
						//ParticleEffect.FLAME.display(0, 0, 0, 3, 1, p.getLocation(), 100);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 34);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.LAVA, p.getLocation(), 28);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.DRIP_LAVA, p.getLocation(),31);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.DRIP_LAVA, p.getLocation(), 32);
						break;
					case "WATER":
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.WATER_BUBBLE, p.getLocation(), 34);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.WATER_SPLASH, p.getLocation(), 28);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.WATER_WAKE, p.getLocation(), 31);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.DRIP_WATER, p.getLocation(), 31);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.WATER_DROP, p.getLocation(), 31);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.WATER_BUBBLE, p.getLocation(), 38);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.WATER_SPLASH, p.getLocation(), 25);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.WATER_WAKE, p.getLocation(), 30);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.DRIP_WATER, p.getLocation(), 29);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.WATER_DROP, p.getLocation(), 36);
						break;
					case "GRAY":
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.CLOUD, p.getLocation(), 34);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.CLOUD, p.getLocation(), 28, 7);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.SMOKE_LARGE, p.getLocation(), 31, 7);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.SMOKE_LARGE, p.getLocation(), 31, 21);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.SMOKE_LARGE, p.getLocation(), 31, 15);
						break;
					case "MUSIC":
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.NOTE, p.getLocation(), 34);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.CRIT, p.getLocation(), 28, 7);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.NOTE, p.getLocation(), 31, 7);
						break;
					case "RAINBOW":
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.SMOKE_NORMAL, p.getLocation(), 34);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.HEART, p.getLocation(), 28);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 32);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 29);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 44);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 24);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 31);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 31);
						Bukkit.getWorld(p.getWorld().getName()).spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 31);
						break;
					}
				}
				catch(NullPointerException e){}//in case
			}
		}, 3L, 3L);
	}
}
