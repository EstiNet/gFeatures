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
import net.estinet.gFeatures.Feature.Shop.SetTrail;
import net.estinet.gFeatures.Feature.Shop.Shop;
import net.estinet.gFeatures.Feature.Shop.Enums.Trails;

public class TrailShop {
	public void init(Player player){
		InventoryAPI open = makeInventory(player);
		open.open(player);
		player.updateInventory();
	}
	public InventoryAPI makeInventory(Player p){
		try{
			InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Trails", 18, new InventoryAPI.OptionClickEventHandler() {
				@Override
				public void onOptionClick(InventoryAPI.OptionClickEvent event) {
					if(event.getName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.RED + "No Trail" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->")){
						SetTrail st = new SetTrail();
						st.init(p, Trails.NONE);
					}
					else if(event.getName().equalsIgnoreCase(getText(p, Trails.FIRE) + "Fire Trail")){
						SetTrail st = new SetTrail();
						st.init(p, Trails.FIRE);
					}
					event.setWillClose(true);
					event.setWillDestroy(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			
			//Fire Trail
			if(!Shop.getTrail(p.getUniqueId().toString(), Trails.FIRE.toString()).equalsIgnoreCase("true")){
				menu.setOption(0, createItem(Material.BLAZE_POWDER, getText(p, Trails.FIRE) + "Fire Trail", ChatColor.GRAY + "Who doesn't like fire?", ChatColor.BLUE + "Costs 450 clupic."));
			}
			else{
				if(Shop.playerTrail.get(p.getUniqueId()).equals("FIRE")){
					menu.setOption(0, createItem(Material.BLAZE_POWDER, getText(p, Trails.FIRE) + "Fire Trail", ChatColor.GRAY + "Who doesn't like fire?", ChatColor.GREEN + "Currently enabled!"));
				}
				else{
					menu.setOption(0, createItem(Material.BLAZE_POWDER, getText(p, Trails.FIRE) + "Fire Trail", ChatColor.GRAY + "Who doesn't like fire?", ChatColor.GREEN + "Click to ENABLE."));
				}
			}
			
			
			
			
			menu.setOption(8, createItem(Material.BARRIER, ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "<---" + ChatColor.RESET + ChatColor.RED + "No Trail" + ChatColor.RESET + ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + "--->"));

			return menu;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public ChatColor getText(Player p, Trails trail){
		if(Shop.getTrail(p.getUniqueId().toString(), trail.toString())){
			return ChatColor.GREEN;
		}
		else{
			return ChatColor.RED;
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
