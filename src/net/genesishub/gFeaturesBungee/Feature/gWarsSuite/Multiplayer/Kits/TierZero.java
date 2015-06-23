package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Finish;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.shampaggon.crackshot.CSUtility;

public class TierZero{
	ClearInventory ci = new ClearInventory();
	Player p;
	ItemStack sniper, shotgun, special, autorifle, ammo;
	public TierZero(Player player) {
		p = player;
		
		sniper = createItem(Material.WOOD_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "Sniper");
		shotgun = createItem(Material.WOOD_SPADE, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "Shotgun");
		special = createItem(Material.WOOD_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Armoured");
		autorifle = createItem(Material.WOOD_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "Auto-Rifle");
		ammo = new ItemStack(Material.MELON_SEEDS, 16);
		ItemMeta meta = ammo.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Ammo");
		ammo.setItemMeta(meta);
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
    	finali();
	}
	public void shotgun(){
		ci.clearInv(p);
		CSUtility cs = new CSUtility();
    	cs.giveWeapon(p, "Shotgun", 1);
    	cs.giveWeapon(p, "Python", 1);
    	finali();
	}
	public void sniper(){
		ci.clearInv(p);
		CSUtility cs = new CSUtility();
    	cs.giveWeapon(p, "Sniper", 1);
    	cs.giveWeapon(p, "Python", 1);
    	finali();
	}
	public void special(){
		ci.clearInv(p);
		CSUtility cs = new CSUtility();
    	cs.giveWeapon(p, "Shotgun", 1);
    	cs.giveWeapon(p, "Python", 1);
    	finali();
	}
	
	public void interact(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(p.getItemInHand().equals(sniper)){
			sniper();
		}
		else if(p.getItemInHand().equals(shotgun)){
			shotgun();
		}
		else if(p.getItemInHand().equals(special)){
			special();
		}
		else if(p.getItemInHand().equals(autorifle)){
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
		Finish finish = new Finish();
		finish.intialize(p);
	}
}
