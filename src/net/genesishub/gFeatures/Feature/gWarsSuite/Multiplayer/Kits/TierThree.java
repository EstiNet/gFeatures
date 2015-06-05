package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TierThree{
	Player p;
	ClearInventory ci = new ClearInventory();
	ItemStack sniper3, shotgun3, special3, autorifle3;
	public TierThree(Player player) {
		p = player;
		sniper3 = createItem(Material.IRON_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "SR-25");
		shotgun3 = createItem(Material.IRON_SPADE, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "FN-TPS");
		special3 = createItem(Material.IRON_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Assassin");
		autorifle3 = createItem(Material.IRON_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "Beretta ARX100");
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
		finali();
	}
	public void shotgun(){
		ci.clearInv(p);
		finali();
	}
	public void sniper(){
		ci.clearInv(p);
		finali();
	}
	public void special(){
		ci.clearInv(p);
		finali();
	}
	public void interact(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(p.getItemInHand().equals(sniper3)){
			sniper();
		}
		else if(p.getItemInHand().equals(shotgun3)){
			shotgun();
		}
		else if(p.getItemInHand().equals(special3)){
			special();
		}
		else if(p.getItemInHand().equals(autorifle3)){
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
		
	}
}
