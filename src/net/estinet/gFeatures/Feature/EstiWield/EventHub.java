package net.estinet.gFeatures.Feature.EstiWield;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.minecraft.server.v1_9_R1.PacketPlayOutAnimation;

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

public class EventHub{
	
	public void onPlayerJoin(PlayerJoinEvent event){
		EstiWield.direction.put(event.getPlayer().getUniqueId(), Hand.RIGHT);
	}

	public void onPlayerAnimate(PlayerInteractEntityEvent event) {
		Bukkit.getLogger().info("yep");
		CraftPlayer cp = (CraftPlayer) event.getPlayer();
		if(ifSwords(event.getPlayer())){
				if(!EstiWield.direction.get(event.getPlayer().getUniqueId()).equals(Hand.RIGHT)){
					Bukkit.getLogger().info("yep");
					PacketPlayOutAnimation ppoa = new PacketPlayOutAnimation(cp.getHandle(), 2);
					cp.getHandle().playerConnection.sendPacket(ppoa);
				}
		}
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		EstiWield.direction.remove(event.getPlayer().getUniqueId());
	}
	public boolean ifSwords(Player p){
		Bukkit.getLogger().info("yep");
		if(p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.GOLD_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.STONE_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.WOOD_SWORD) || p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_AXE) || p.getInventory().getItemInMainHand().getType().equals(Material.IRON_AXE) || p.getInventory().getItemInMainHand().getType().equals(Material.GOLD_AXE) || p.getInventory().getItemInMainHand().getType().equals(Material.STONE_AXE) || p.getInventory().getItemInMainHand().getType().equals(Material.WOOD_AXE)){
			if(p.getInventory().getItemInOffHand().getType().equals(Material.DIAMOND_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.IRON_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.GOLD_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.STONE_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.WOOD_SWORD) || p.getInventory().getItemInOffHand().getType().equals(Material.DIAMOND_AXE) || p.getInventory().getItemInOffHand().getType().equals(Material.IRON_AXE) || p.getInventory().getItemInOffHand().getType().equals(Material.GOLD_AXE) || p.getInventory().getItemInOffHand().getType().equals(Material.STONE_AXE) || p.getInventory().getItemInOffHand().getType().equals(Material.WOOD_AXE)){
				Bukkit.getLogger().info("yep");
				return true;
			}
		}
		return false;
	}
}
