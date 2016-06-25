package net.estinet.gFeatures.Feature.Friendship.Menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.estinet.gFeatures.API.Inventory.InventoryAPI;
//import net.estinet.gFeatures.API.Inventory.EstiInventory;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.Friendship.Friendship;

public class FriendsMenu {
	public void init(Player player){
		InventoryAPI open = makeInventory(player);
		open.open(player);
	}
	public InventoryAPI makeInventory(Player p){
		try{
			InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Friends Menu", 9, new InventoryAPI.OptionClickEventHandler() {
				@Override
				public void onOptionClick(InventoryAPI.OptionClickEvent event) {
					if(event.getName().equalsIgnoreCase(ChatColor.GOLD + "Friends List")){
						
						Friendship.cacheNames.add(p.getName());
						CliotePing cp = new CliotePing();
						cp.sendMessage("friends list " + p.getName(), "Bungee");
					}
					else if(event.getName().equalsIgnoreCase(ChatColor.GOLD + "Add Friend")){
						
					}
					else if(event.getName().equalsIgnoreCase(ChatColor.GOLD + "Remove Friend")){
						
					}
					else if(event.getName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Profile")){
						
					}
					event.setWillClose(true);
					event.setWillDestroy(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			
			menu.setOption(0, createItem(Material.SKULL_ITEM, ChatColor.GOLD + "Friends List"));
			menu.setOption(1, createItem(Material.ARROW, ChatColor.GOLD + "Add Friend"));
			menu.setOption(2, createItem(Material.BARRIER, ChatColor.GOLD + "Remove Friend"));
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1);
			SkullMeta sm = (SkullMeta) skull.getItemMeta();
			sm.setOwner(p.getName());
			sm.setDisplayName(ChatColor.DARK_AQUA + "Profile");
			skull.setItemMeta(sm);
			menu.setOption(8, skull);
			
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
