package net.estinet.gFeatures.Feature.SurvivalTwo.Menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.estinet.gFeatures.API.EssentialsHook.EssentialsEcoUtil;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;

public class Confirm {
	public void init(Player player, String price, Material give, String name){
		InventoryAPI open = makeInventory(player, price, give, name);
		open.open(player);
		player.updateInventory();
	}
	public InventoryAPI makeInventory(Player p, String price, Material give, String name){
		try{
			InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Buy protection stone? It's " + ChatColor.DARK_AQUA + "$" + price, 9, new InventoryAPI.OptionClickEventHandler() {
				@Override
				public void onOptionClick(InventoryAPI.OptionClickEvent event) {
					if(event.getName().equalsIgnoreCase(ChatColor.GREEN + "Yes")){
						if(EssentialsEcoUtil.getMoney(p.getUniqueId()) >= Double.parseDouble(price)){
							Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "eco take " + Double.parseDouble(price));
							if(p.getInventory().firstEmpty() == -1){
								p.getWorld().dropItem(p.getLocation(), createItem(give, name, ChatColor.GOLD + "ヾ(⌐■_■)ノ♪ Nobody's gonna touch my stuff!"));
							}
							else{
								p.getInventory().addItem(createItem(give, name, ChatColor.GOLD + "ヾ(⌐■_■)ノ♪ Nobody's gonna touch my stuff!"));
							}
							p.sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "You got a protection stone!");
						}
						else{
							p.sendMessage(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Esti" + ChatColor.GOLD + "Net" + ChatColor.RESET + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "" + ChatColor.AQUA + "You don't have enough money!");
						}
					}
					else if(event.getName().equalsIgnoreCase(ChatColor.RED + "No")){
						Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
							public void run(){
								Shop shop = new Shop();
								shop.init(p);
							}
						}, 5L);
					}
					event.setWillClose(true);
					event.setWillDestroy(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short) 5);
			ItemMeta im = pane.getItemMeta();
			im.setDisplayName(ChatColor.GREEN + "Yes");
			pane.setItemMeta(im);
			
			ItemStack pane1 = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short) 14);
			ItemMeta im1 = pane1.getItemMeta();
			im1.setDisplayName(ChatColor.RED + "No");
			pane1.setItemMeta(im1);
			
			menu.setOption(0, pane);
			menu.setOption(1, pane);
			menu.setOption(2, pane);
			menu.setOption(3, pane);
			menu.setOption(4, createItem(give, name));
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
