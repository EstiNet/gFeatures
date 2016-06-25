package net.estinet.gFeatures.Feature.Friendship.Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.estinet.gFeatures.API.Inventory.InventoryAPI;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;

public class FriendsAccept {
	public void init(Player player, String name){
		InventoryAPI open = makeInventory(player, name);
		open.open(player);
	}
	public InventoryAPI makeInventory(Player p, String name){
		try{
			InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Accept friend request?", 9, new InventoryAPI.OptionClickEventHandler() {
				@Override
				public void onOptionClick(InventoryAPI.OptionClickEvent event) {
					if(event.getName().equalsIgnoreCase(ChatColor.GREEN + "Accept")){
						CliotePing cp = new CliotePing();
						cp.sendMessage("friends confirm " + p.getName() + " " + name, "Bungee");
					}
					else if(event.getName().equalsIgnoreCase(ChatColor.RED + "Deny")){
						CliotePing cp = new CliotePing();
						cp.sendMessage("friends unfriend " + p.getName() + " " + name, "Bungee");
					}
					event.setWillClose(true);
					event.setWillDestroy(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short) 5);
			ItemMeta im = pane.getItemMeta();
			im.setDisplayName(ChatColor.GREEN + "Accept");
			pane.setItemMeta(im);
			
			ItemStack pane1 = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short) 14);
			ItemMeta im1 = pane1.getItemMeta();
			im1.setDisplayName(ChatColor.RED + "Deny");
			pane1.setItemMeta(im1);
			
			menu.setOption(0, pane);
			menu.setOption(1, pane);
			menu.setOption(2, pane);
			menu.setOption(3, pane);
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1);
			SkullMeta sm = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
			sm.setOwner(name);
			sm.setDisplayName(ChatColor.AQUA + "<" + ChatColor.WHITE +(String) name + ChatColor.AQUA + ">");
			skull.setItemMeta(sm);
			menu.setOption(4, skull);
			menu.setOption(5, pane1);
			menu.setOption(6, pane1);
			menu.setOption(7, pane1);
			menu.setOption(8, pane1);

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
