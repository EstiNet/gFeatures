package net.estinet.gFeatures.Feature.SurvivalTwo.Menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

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

public class SelectPlayerMenu {
	public void init(Player player, MenuRunnable mr){
		InventoryAPI open = makeInventory(player, mr);
		open.open(player);
		player.updateInventory();
	}
	public InventoryAPI makeInventory(Player p, MenuRunnable mr){
		try{
			int calculatenum = (int) (Math.ceil(Bukkit.getOnlinePlayers().size()/9)*9);
			InventoryAPI menu = new InventoryAPI(ChatColor.AQUA + "Choose a player.", calculatenum, event -> {
				mr.event = event;
				mr.p = p;
				mr.run();
				event.setWillClose(true);
				event.setWillDestroy(true);
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));

			int i = 0;
			
			for(Player player : Bukkit.getOnlinePlayers()){
				if(player.getName().equals(p.getName())){
					continue;
				}
				ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner(player.getName());
				meta.setDisplayName(player.getDisplayName());
				skull.setItemMeta(meta);
				menu.setOption(i, skull);
				i++;
			}
			
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
