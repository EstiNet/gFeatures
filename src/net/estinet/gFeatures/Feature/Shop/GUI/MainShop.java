package net.estinet.gFeatures.Feature.Shop.GUI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;
import net.estinet.gFeatures.Feature.GenesisEconomy.MoneyManager;
import net.estinet.gFeatures.Feature.Shop.Shop;

public class MainShop {
	public void init(Player player){
		InventoryAPI open = makeInventory(player);
		open.open(player);
		player.updateInventory();
	}
	public InventoryAPI makeInventory(Player p){
		try{
			InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Cosmetics", 18, new InventoryAPI.OptionClickEventHandler() {
				@Override
				public void onOptionClick(InventoryAPI.OptionClickEvent event) {
					if(event.getName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_AQUA + "Trails" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->")){
						
					}
					event.setWillClose(true);
					event.setWillDestroy(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			
			MoneyManager mm = new MoneyManager();
			
			menu.setOption(0, createItem(Material.BLAZE_POWDER, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.DARK_AQUA + "Trails" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->"), ChatColor.GRAY + "" + Shop.getNumOfTrails(p.getUniqueId().toString()) + "/" + Shop.getTotalNumOfTrails() + " trails owned.");
			menu.setOption(8, createItem(Material.EMERALD, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.GREEN + "Clupic" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->"), ChatColor.GRAY + "You have " + mm.getMoney(p) + " clupic.");

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
	public ItemStack createItem(Material material, String name, short met, String ... lore){
		ItemStack item = new ItemStack(material, 1, met);
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
