package net.estinet.gFeatures.Feature.EstiWield;

import java.lang.reflect.Field;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.API.Packets.Reflection;
import net.estinet.gFeatures.API.Packets.Reflection.FieldAccessor;
import net.estinet.gFeatures.API.Packets.TinyProtocol;
import net.minecraft.server.v1_9_R1.PacketDataSerializer;
import net.minecraft.server.v1_9_R1.PacketPlayInArmAnimation;
import net.minecraft.server.v1_9_R1.PacketPlayInUseEntity;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

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

public class EventHub{
	
	private Class<?> particleClass = Reflection.getClass("{nms}.PacketPlayOutWorldParticles");
	private FieldAccessor<String> particleName = Reflection.getField(particleClass, String.class, 0);
	private FieldAccessor<Float> particleX = Reflection.getField(particleClass, float.class, 0);
	private FieldAccessor<Float> particleY = Reflection.getField(particleClass, float.class, 1);
	private FieldAccessor<Float> particleZ = Reflection.getField(particleClass, float.class, 2);
	private FieldAccessor<Integer> particleCount = Reflection.getField(particleClass, int.class, 0);
	
	private TinyProtocol protocol;

	
	public void onPlayerJoin(PlayerJoinEvent event){
		EstiWield.direction.put(event.getPlayer().getUniqueId(), Hand.RIGHT);
	}

	public void onPlayerAnimate(PlayerInteractEntityEvent event) {
		CraftPlayer cp = (CraftPlayer) event.getPlayer();
		if(ifSwords(event.getPlayer())){
				if(!EstiWield.direction.get(event.getPlayer().getUniqueId()).equals(Hand.RIGHT)){
					try {
						// Only visible for the client
						Object explosionPacket = particleClass.newInstance();
						Location loc = event.getPlayer().getLocation();
						particleName.set(explosionPacket, "hugeexplosion");
						particleX.set(explosionPacket, (float) loc.getX());
						particleY.set(explosionPacket, (float) loc.getY());
						particleZ.set(explosionPacket, (float) loc.getZ());
						particleCount.set(explosionPacket, 1);

						// Send the packet to the player
						protocol.sendPacket(event.getPlayer(), explosionPacket);
					} catch (Exception e) {
						throw new RuntimeException("Cannot send packet.", e);
					}
				}
		}
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		EstiWield.direction.remove(event.getPlayer().getUniqueId());
	}
	public boolean ifSwords(Player p){
		if(p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.GOLD_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.STONE_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.WOOD_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_AXE) || p.getInventory().getItemInMainHand().getType().equals(Material.IRON_AXE) || p.getInventory().getItemInMainHand().getType().equals(Material.GOLD_AXE) || p.getInventory().getItemInMainHand().getType().equals(Material.STONE_AXE) || p.getInventory().getItemInMainHand().getType().equals(Material.WOOD_AXE)){
			if(p.getInventory().getItemInOffHand().getType().equals(Material.DIAMOND_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.IRON_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.GOLD_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.STONE_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.WOOD_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.DIAMOND_AXE) || p.getInventory().getItemInOffHand().getType().equals(Material.IRON_AXE) || p.getInventory().getItemInOffHand().getType().equals(Material.GOLD_AXE) || p.getInventory().getItemInOffHand().getType().equals(Material.STONE_AXE) || p.getInventory().getItemInOffHand().getType().equals(Material.WOOD_AXE)){
				return true;
			}
		}
		return false;
	}
}
