package net.estinet.gFeatures.Feature.SurvivalTwo;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

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

public class EventHub{
	public void onPlayerInteract(PlayerInteractEvent event){
		Block block = event.getPlayer().getTargetBlock(new HashSet<Byte>(), 100);
		if(event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.COMMAND)){
			removeBlock(event, Material.COMMAND, block);
		}
		else if(event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.COMMAND_CHAIN)){
			removeBlock(event, Material.COMMAND_CHAIN, block);
		}
		else if(event.getAction().equals(Action.LEFT_CLICK_BLOCK) && block.getType().equals(Material.COMMAND_REPEATING)){
			removeBlock(event, Material.COMMAND_REPEATING, block);
		}
		else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMMAND)){
			placeBlock(event, Material.COMMAND, block, true);
		}
		else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.COMMAND)){
			placeBlock(event, Material.COMMAND, block, false);
		}
		else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMMAND_CHAIN)){
			placeBlock(event, Material.COMMAND_CHAIN, block, true);
		}
		else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.COMMAND_CHAIN)){
			placeBlock(event, Material.COMMAND_CHAIN, block, false);
		}
		else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMMAND_REPEATING)){
			placeBlock(event, Material.COMMAND_REPEATING, block, true);
		}
		else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.COMMAND_REPEATING)){
			placeBlock(event, Material.COMMAND_REPEATING, block, false);
		}
	}
	public void placeBlock(PlayerInteractEvent event, Material material, Block block, boolean hand){
		Block b = getPlaceBlock(event.getBlockFace(), block);
		b.setType(material);
		if(hand){
			BlockPlaceEvent bpe = new BlockPlaceEvent(b, b.getState(), block, event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), true, EquipmentSlot.HAND);
			Bukkit.getServer().getPluginManager().callEvent(bpe);
		}
		else{
			BlockPlaceEvent bpe = new BlockPlaceEvent(b, b.getState(), block, event.getPlayer().getInventory().getItemInOffHand(), event.getPlayer(), true, EquipmentSlot.OFF_HAND);
			Bukkit.getServer().getPluginManager().callEvent(bpe);
		}
	}
	public Block getPlaceBlock(BlockFace bf, Block block){
		if(bf.equals(BlockFace.DOWN)){
			return block.getWorld().getBlockAt(block.getX(), block.getY()-1, block.getZ());
		}
		else if(bf.equals(BlockFace.UP)){
			return block.getWorld().getBlockAt(block.getX(), block.getY()+1, block.getZ());
		}
		else if(bf.equals(BlockFace.EAST)){
			return block.getWorld().getBlockAt(block.getX()+1, block.getY(), block.getZ());
		}
		else if(bf.equals(BlockFace.WEST)){
			return block.getWorld().getBlockAt(block.getX()-1, block.getY(), block.getZ());
		}
		else if(bf.equals(BlockFace.NORTH)){
			return block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ()-1);
		}
		else if(bf.equals(BlockFace.SOUTH)){
			return block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ()+1);
		}
		else{
			return block.getWorld().getBlockAt(block.getX(), block.getY(), block.getZ());
		}
	}
	public void removeBlock(PlayerInteractEvent event, Material material, Block block){
		BlockBreakEvent blockevent = new BlockBreakEvent(block, event.getPlayer());
		event.getPlayer().sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "You've removed your protection stone.");
		if(event.getPlayer().getInventory().firstEmpty() == -1){
			event.getPlayer().sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "Your inventory was full, dropping it on the floor.");
			event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), new ItemStack(material, 1));
		}
		else{
			event.getPlayer().getInventory().addItem(new ItemStack(material, 1));
		}
		Bukkit.getServer().getPluginManager().callEvent(blockevent);
	}
}
