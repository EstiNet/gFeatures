package net.estinet.gFeatures.Feature.CTF.Holo;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.shampaggon.crackshot.CSUtility;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Respawn;

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

public class SpawnMenu {
	ItemStack item1, item2, item3, item4;
	ClearInventory ci = new ClearInventory();
	Respawn respawn = new Respawn();
	public void init(Player p){
		ci.clearInv(p);
		
		item1 = new ItemStack(Material.IRON_PICKAXE, 1);
		ItemMeta item1meta = (ItemMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Plasma Sniper");
		item1.setItemMeta(item1meta);
		
		item2 = new ItemStack(Material.IRON_SPADE, 1);
		ItemMeta item2meta = (ItemMeta) item2.getItemMeta();
		item2meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Plasma Shotgun");
		item2.setItemMeta(item2meta);
		
		item3 = new ItemStack(Material.IRON_AXE, 1);
		ItemMeta item3meta = (ItemMeta) item3.getItemMeta();
		item3meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Laser Rifle");
		item3.setItemMeta(item3meta);
		
		item4 = new ItemStack(Material.IRON_HOE, 1);
		ItemMeta item4meta = (ItemMeta) item4.getItemMeta();
		item4meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Dual Laser Pistols");
		item4.setItemMeta(item4meta);
		
		p.getInventory().setItem(0, item1);
		p.getInventory().setItem(1, item2);
		p.getInventory().setItem(2, item3);
		p.getInventory().setItem(3, item4);
	}
	public void interact(PlayerInteractEvent event){
		Player p = event.getPlayer();
		
		item1 = new ItemStack(Material.IRON_PICKAXE, 1);
		ItemMeta item1meta = (ItemMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Plasma Sniper");
		item1.setItemMeta(item1meta);
		
		item2 = new ItemStack(Material.IRON_SPADE, 1);
		ItemMeta item2meta = (ItemMeta) item2.getItemMeta();
		item2meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Plasma Shotgun");
		item2.setItemMeta(item2meta);
		
		item3 = new ItemStack(Material.IRON_AXE, 1);
		ItemMeta item3meta = (ItemMeta) item3.getItemMeta();
		item3meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Laser Rifle");
		item3.setItemMeta(item3meta);
		
		item4 = new ItemStack(Material.IRON_HOE, 1);
		ItemMeta item4meta = (ItemMeta) item4.getItemMeta();
		item4meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "Dual Laser Pistols");
		item4.setItemMeta(item4meta);
		
		if(p.getItemInHand().equals(item1)){
			ci.clearInv(p);
			CSUtility cs = new CSUtility();
			cs.giveWeapon(p, "PlasmaSniper", 1);
			respawn.fullrespawn(p);
		}
		else if(p.getItemInHand().equals(item2)){
			ci.clearInv(p);
			CSUtility cs = new CSUtility();
			cs.giveWeapon(p, "PlasmaShotgun", 1);
			respawn.fullrespawn(p);
		}
		else if(p.getItemInHand().equals(item3)){
			ci.clearInv(p);
			CSUtility cs = new CSUtility();
			cs.giveWeapon(p, "LaserRifle", 1);
			respawn.fullrespawn(p);
		}
		else if(p.getItemInHand().equals(item4)){
			ci.clearInv(p);
			CSUtility cs = new CSUtility();
			cs.giveWeapon(p, "DualLaserPistols", 1);
			respawn.fullrespawn(p);
		}
	}
}
