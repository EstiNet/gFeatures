package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.shampaggon.crackshot.CSUtility;

public class TierOne{
	Player p;
	ItemStack sniper1, shotgun1, special1, autorifle1;
	public TierOne(Player player) {
		p  = player;
		sniper1 = createItem(Material.STONE_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "ULR338");
		shotgun1 = createItem(Material.STONE_SPADE, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "Colt Model 1");
		special1 = createItem(Material.STONE_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Rocket Launcher");
		autorifle1 = createItem(Material.STONE_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "m16");
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
		CSUtility cs = new CSUtility();
		cs.giveWeapon(p, "m16", 1);
		cs.giveWeapon(p, "Python", 1);
		finali();
	}
	public void shotgun(){
		CSUtility cs = new CSUtility();
		cs.giveWeapon(p, "Colt Model 1", 1);
		cs.giveWeapon(p, "Python", 1);
		finali();
	}
	public void sniper(){
		CSUtility cs = new CSUtility();
		cs.giveWeapon(p, "ULR338", 1);
		cs.giveWeapon(p, "Python", 1);
		finali();
	}
	public void special(){
		CSUtility cs = new CSUtility();
		cs.giveWeapon(p, "Bazooka", 1);
		cs.giveWeapon(p, "Python", 1);
		finali();
	}
	public void interact(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(p.getItemInHand().equals(sniper1)){
			sniper();
		}
		else if(p.getItemInHand().equals(shotgun1)){
			shotgun();
		}
		else if(p.getItemInHand().equals(special1)){
			special();
		}
		else if(p.getItemInHand().equals(autorifle1)){
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
