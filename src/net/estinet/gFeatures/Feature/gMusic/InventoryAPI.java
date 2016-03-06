package net.estinet.gFeatures.Feature.gMusic;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

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

public class InventoryAPI implements Listener {
	 private String name;
	    private int size;
	    private OptionClickEventHandler handler;
	    private Plugin plugin;
	   
	    private String[] optionNames;
	    private ItemStack[] optionIcons;
	   
	    public InventoryAPI(String name, int size, OptionClickEventHandler handler, Plugin plugin) {
	        this.name = name;
	        this.size = size;
	        this.handler = handler;
	        this.plugin = plugin;
	        this.optionNames = new String[size];
	        this.optionIcons = new ItemStack[size];
	        plugin.getServer().getPluginManager().registerEvents(this, plugin);
	    }
	   
	    public InventoryAPI setOption(int position, ItemStack icon, String name, String... info) {
	        optionNames[position] = name;
	        optionIcons[position] = setItemNameAndLore(icon, name, info);
	        return this;
	    }
	   
	    public void open(Player player) {
	        Inventory inventory = Bukkit.createInventory(player, size, name);
	        for (int i = 0; i < optionIcons.length; i++) {
	            if (optionIcons[i] != null) {
	                inventory.setItem(i, optionIcons[i]);
	            }
	        }
	        player.openInventory(inventory);
	    }
	   
	    public void destroy() {
	        HandlerList.unregisterAll(this);
	        handler = null;
	        plugin = null;
	        optionNames = null;
	        optionIcons = null;
	    }
	   
	    @EventHandler(priority=EventPriority.MONITOR)
	    void onInventoryClick(InventoryClickEvent event) {
	        if (event.getInventory().getTitle().equals(name)) {
	            event.setCancelled(true);
	            int slot = event.getRawSlot();
	            if (slot >= 0 && slot < size && optionNames[slot] != null) {
	                Plugin plugin = this.plugin;
	                OptionClickEvent e = new OptionClickEvent((Player)event.getWhoClicked(), slot, optionNames[slot]);
	                handler.onOptionClick(e);
	                if (e.willClose()) {
	                    final Player p = (Player)event.getWhoClicked();
	                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
	                        public void run() {
	                            p.closeInventory();
	                        }
	                    }, 1);
	                }
	                if (e.willDestroy()) {
	                    destroy();
	                }
	            }
	        }
	    }
	   
	    public interface OptionClickEventHandler {
	        public void onOptionClick(OptionClickEvent event);      
	    }
	   
	    public class OptionClickEvent {
	        private Player player;
	        private int position;
	        private String name;
	        private boolean close;
	        private boolean destroy;
	       
	        public OptionClickEvent(Player player, int position, String name) {
	            this.player = player;
	            this.position = position;
	            this.name = name;
	            this.close = true;
	            this.destroy = false;
	        }
	       
	        public Player getPlayer() {
	            return player;
	        }
	       
	        public int getPosition() {
	            return position;
	        }
	       
	        public String getName() {
	            return name;
	        }
	       
	        public boolean willClose() {
	            return close;
	        }
	       
	        public boolean willDestroy() {
	            return destroy;
	        }
	       
	        public void setWillClose(boolean close) {
	            this.close = close;
	        }
	       
	        public void setWillDestroy(boolean destroy) {
	            this.destroy = destroy;
	        }
	    }
	   
	    private ItemStack setItemNameAndLore(ItemStack item, String name, String[] lore) {
	        ItemMeta im = item.getItemMeta();
	            im.setDisplayName(name);
	            im.setLore(Arrays.asList(lore));
	        item.setItemMeta(im);
	        return item;
	    }
	}
