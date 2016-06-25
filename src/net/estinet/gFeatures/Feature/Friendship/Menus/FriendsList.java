package net.estinet.gFeatures.Feature.Friendship.Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.estinet.gFeatures.API.Inventory.InventoryAPI;

public class FriendsList {
	public void init(HashMap<String, String> hash, String player){
		InventoryAPI open = makeInventory(hash, Bukkit.getPlayer(player));
		open.open(Bukkit.getPlayer(player));
	}
	public InventoryAPI makeInventory(HashMap<String, String> hash, Player p){
		try{
			int amount = 9;
			if(hash.size() < 44){
				amount = (int)(hash.size() / amount) * 9 + 9; 
			}
			else{
				//will add later (Overflow friends (too many) needz more pages) plz future espidev :/:/
				amount = 45;
			}
			InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Friends List", amount, new InventoryAPI.OptionClickEventHandler() {
				@Override
				public void onOptionClick(InventoryAPI.OptionClickEvent event) {
					
					//add player options????
					
					event.setWillClose(false);
					event.setWillDestroy(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			
			for(int i = 0 ; i < hash.size(); i++){
				ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1);
				//SkullMeta sm = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
				SkullMeta sm = (SkullMeta) skull.getItemMeta();
				sm.setOwner((String) hash.keySet().toArray()[i]);
				sm.setDisplayName(ChatColor.AQUA + "<" + ChatColor.WHITE +(String) hash.keySet().toArray()[i] + ChatColor.AQUA + ">");
				sm.setLore(Arrays.asList((String)hash.values().toArray()[i].toString().split("\n")[0], (String)hash.values().toArray()[i].toString().split("\n")[1]));
				skull.setItemMeta(sm);
				menu.setOption(i, skull);
			}
			
			return menu;
		}
		catch(NullPointerException e){}
		catch(Exception e){
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