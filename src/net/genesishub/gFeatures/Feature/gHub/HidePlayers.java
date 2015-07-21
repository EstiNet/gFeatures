package net.genesishub.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HidePlayers {
	ItemStack stacker;
	public void show(Player p){
		for(Player player : Bukkit.getOnlinePlayers()){
			p.hidePlayer(player);
		}
		stacker = createItem(Material.REDSTONE, ChatColor.AQUA + "Show Players");
		p.getInventory().setItem(p.getInventory().getHeldItemSlot(), stacker);
	}
	public void hide(Player p){
		for(Player player : Bukkit.getOnlinePlayers()){
			p.showPlayer(player);
		}
		stacker = createItem(Material.SULPHUR, ChatColor.AQUA + "Hide Players");
		p.getInventory().setItem(1, stacker);
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
