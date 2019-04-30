package net.estinet.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class Compass {
	public void init(Player p){

	}
	public InventoryAPI makeInventory(Player p, String name){
		try{
			InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Accept friend request?", 9, event -> {
				if(event.getName().equalsIgnoreCase("")){

				}
				else if(event.getName().equalsIgnoreCase("")){

				}
				event.setWillClose(true);
				event.setWillDestroy(true);
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));
			ItemStack pane = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
			ItemMeta im = pane.getItemMeta();
			im.setDisplayName(ChatColor.GREEN + "Accept");
			pane.setItemMeta(im);
			
			menu.setOption(0, pane);
			menu.setOption(1, pane);
			menu.setOption(2, pane);
			menu.setOption(3, pane);

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
