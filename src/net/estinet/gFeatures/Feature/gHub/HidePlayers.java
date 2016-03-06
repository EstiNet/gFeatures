package net.estinet.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

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
