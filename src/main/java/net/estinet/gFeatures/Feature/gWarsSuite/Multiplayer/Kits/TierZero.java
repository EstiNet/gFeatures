package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.gWarsSuite.MainMenu.Finish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.shampaggon.crackshot.CSUtility;

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

public class TierZero{
	ClearInventory ci = new ClearInventory();
	Player p;
	ItemStack sniper, shotgun, special, autorifle, ammo, jetpackammo;
	public TierZero(Player player) {
		p = player;
		
		sniper = createItem(Material.WOODEN_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "Sniper");
		shotgun = createItem(Material.WOODEN_SHOVEL, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "Shotgun");
		special = createItem(Material.WOODEN_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Crossbow");
		autorifle = createItem(Material.WOODEN_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "Auto-Rifle");
		ammo = new ItemStack(Material.MELON_SEEDS, 16);
		ItemMeta meta = ammo.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Ammo");
		ammo.setItemMeta(meta);
		jetpackammo = new ItemStack(Material.COAL, 1);
		ItemMeta jmeta = jetpackammo.getItemMeta();
		jmeta.setDisplayName(ChatColor.GOLD + "Jetpack Fuel");
		jetpackammo.setItemMeta(jmeta);
	}
	public void initialize(String value){
		switch(value){
		case "AUTORIFLE":
			autorifle();
			break;
		case "SHOTGUN":
			shotgun();
			break;
		case "SNIPER":
			sniper();
			break;
		case "SPECIAL": 
			special();
			break;
		}
	}
	public void autorifle(){
		ci.clearInv(p);
		CSUtility cs = new CSUtility();
    	cs.giveWeapon(p, "Auto-Rifle", 1);
    	cs.giveWeapon(p, "Python", 1);
    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "jetpacks cheat jetpackplus "+ p.getName());
    	jetpackammo = new ItemStack(Material.COAL, 3);
		ItemMeta jmeta = jetpackammo.getItemMeta();
		jmeta.setDisplayName(ChatColor.GOLD + "Jetpack Fuel");
		jetpackammo.setItemMeta(jmeta);
    	finali();
	}
	public void shotgun(){
		ci.clearInv(p);
		CSUtility cs = new CSUtility();
    	cs.giveWeapon(p, "Shotgun", 1);
    	cs.giveWeapon(p, "Python", 1);
    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "jetpacks cheat jetpack "+ p.getName());
    	finali();
	}
	public void sniper(){
		ci.clearInv(p);
		CSUtility cs = new CSUtility();
    	cs.giveWeapon(p, "Sniper", 1);
    	cs.giveWeapon(p, "Python", 1);
    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "jetpacks cheat jetpack "+ p.getName());
    	finali();
	}
	public void special(){
		ci.clearInv(p);
		CSUtility cs = new CSUtility();
    	cs.giveWeapon(p, "Crossbow", 1);
    	cs.giveWeapon(p, "Python", 1);
    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "jetpacks cheat jetpack "+ p.getName());
    	finali();
	}
	
	public void interact(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(p.getInventory().getItemInMainHand().equals(sniper)){
			sniper();
		}
		else if(p.getInventory().getItemInMainHand().equals(shotgun)){
			shotgun();
		}
		else if(p.getInventory().getItemInMainHand().equals(special)){
			special();
		}
		else if(p.getInventory().getItemInMainHand().equals(autorifle)){
			autorifle();
		}
	}
	public ItemStack createItem(Material material, String name, String ... lore){
		ItemStack item = new ItemStack(material, 1);
		List<String> lores = new ArrayList<>();
		for(String lor : lore){
		lores.add(lor);
		}
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lores);
		item.setItemMeta(meta);
		return item;
	}
	public void finali(){
		p.getInventory().setItem(8, ammo);
		p.getInventory().setItem(6, jetpackammo);
		Finish finish = new Finish();
		finish.intialize(p);
	}
}
