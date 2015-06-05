package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TierFour{
	Player p;
	public TierFour(Player player) {
		p = player;
	}
	public void initialize(String value){
		switch(value){
		case "AUTORIFLE":
			autorifle(p);
			break;
		case "SHOTGUN":
			shotgun(p);
			break;
		case "SNIPER":
			sniper(p);
			break;
		case "SPECIAL": 
			special(p);
			break;
		}
	}
	public void autorifle(Player p){
		
	}
	public void shotgun(Player p){
		
	}
	public void sniper(Player p){
		
	}
	public void special(Player p){
		
	}
	public void interact(PlayerInteractEvent event){
		
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
}
