package net.estinet.gFeatures.Feature.Friendship;

package net.estinet.gFeatures.Feature.gHub.crystal;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.estinet.gFeatures.API.Inventory.InventoryAPI;
//import net.estinet.gFeatures.API.Inventory.EstiInventory;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.gHub.Basis;

public class FriendsMenu {
	public void init(Location location, Player player){
		InventoryAPI open = makeInventory(player, location);
		open.open(player);
	}
	public InventoryAPI makeInventory(Player p, Location loc){
		try{
			InventoryAPI menu = new InventoryAPI(ChatColor.GRAY + mgs.getName() + " Server Menu", 18, new InventoryAPI.OptionClickEventHandler() {
				@Override
				public void onOptionClick(InventoryAPI.OptionClickEvent event) {
					if(event.getName().equalsIgnoreCase("")){
						
					}
					event.setWillClose(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			ItemStack player = new ItemStack();
			return menu;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
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
