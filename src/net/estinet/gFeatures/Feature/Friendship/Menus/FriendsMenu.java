package net.estinet.gFeatures.Feature.Friendship.Menus;

import java.util.ArrayList;
import java.util.HashMap;
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
//import net.estinet.gFeatures.API.Inventory.EstiInventory;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.Friendship.Friendship;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

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

public class FriendsMenu {
	public void init(Player player){
		InventoryAPI open = makeInventory(player);
		open.open(player);
		player.updateInventory();
	}
	public InventoryAPI makeInventory(Player p){
		try{
			InventoryAPI menu = new InventoryAPI(ChatColor.GOLD + "Friends Menu", 9, new InventoryAPI.OptionClickEventHandler() {
				@Override
				public void onOptionClick(InventoryAPI.OptionClickEvent event) {
					if(event.getName().equalsIgnoreCase(ChatColor.GOLD + "Friends List")){
						try{
							if(Friendship.friendget.get(p.getName()) == null){
								event.getPlayer().sendMessage("[" + ChatColor.GOLD + "Friends" + ChatColor.WHITE + "] Fetching list...");
								Friendship.cacheNames.add(p.getName());
								Friendship.friendget.put(p.getName(), new HashMap<>());
								CliotePing cp = new CliotePing();
								cp.sendMessage("friends list " + p.getName(), "Bungee");
							}
							else{
								event.getPlayer().sendMessage("[" + ChatColor.GOLD + "Friends" + ChatColor.WHITE + "] Still fetching the list...");
							}
						}
						catch(Exception e){
							event.getPlayer().sendMessage("[" + ChatColor.GOLD + "Friends" + ChatColor.WHITE + "] Fetching list...");
							Friendship.cacheNames.add(p.getName());
							Friendship.friendget.put(p.getName(), new HashMap<>());
							CliotePing cp = new CliotePing();
							cp.sendMessage("friends list " + p.getName(), "Bungee");
						}
					}
					else if(event.getName().equalsIgnoreCase(ChatColor.GOLD + "Add Friend")){
						Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
							public void run(){
								FriendsAdd fa = new FriendsAdd();
								fa.init(p);
							}
						}, 9L);
					}
					else if(event.getName().equalsIgnoreCase(ChatColor.GOLD + "Remove Friend")){
						Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
							public void run(){
								FriendsRemove fr = new FriendsRemove();
								fr.init(p);
							}
						}, 9L);
					}
					else if(event.getName().equalsIgnoreCase(ChatColor.GOLD + "Pending Friends")){
						event.getPlayer().sendMessage("[" + ChatColor.GOLD + "Friends" + ChatColor.WHITE + "] Fetching list...");
						Friendship.cacheNames.add(p.getName());
						Friendship.friendreq.put(p.getName(), new ArrayList<>());
						CliotePing cp = new CliotePing();
						cp.sendMessage("friends requests " + p.getName(), "Bungee");
					}
					event.setWillClose(true);
					event.setWillDestroy(true);
				}
			}, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"));

			menu.setOption(0, createItem(Material.SKULL_ITEM, ChatColor.GOLD + "Friends List", (short) SkullType.PLAYER.ordinal()));
			menu.setOption(1, createItem(Material.ARROW, ChatColor.GOLD + "Add Friend"));
			menu.setOption(2, createItem(Material.BARRIER, ChatColor.GOLD + "Remove Friend"));
			menu.setOption(3, createItem(Material.ENCHANTED_BOOK, ChatColor.GOLD + "Pending Friends"));
			ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			//SkullMeta sm = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
			SkullMeta sm = (SkullMeta) skull.getItemMeta();
			sm.setOwner(p.getName());
			sm.setDisplayName(ChatColor.DARK_AQUA + "Hello " + p.getDisplayName() + ".");
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
