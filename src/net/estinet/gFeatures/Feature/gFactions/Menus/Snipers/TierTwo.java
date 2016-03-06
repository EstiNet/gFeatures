package net.estinet.gFeatures.Feature.gFactions.Menus.Snipers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;
import net.estinet.gFeatures.API.PlayerStats.gPlayer;
import net.estinet.gFeatures.Feature.gFactions.Blaze;

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

public class TierTwo {
	public static InventoryAPI makeInventory(final Player p, gPlayer player){
		try{
		InventoryAPI menu = new InventoryAPI("Sniper Tier", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	        	final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	            if(event.getName().equals(ChatColor.BOLD + "" + ChatColor.AQUA +  "Switch to Sniper")){
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		if(!Blaze.invtrigger.contains(p.getName())){
	                		p.sendMessage(ChatColor.BOLD + "[" + ChatColor.AQUA + "Tiers" + ChatColor.BOLD + "] " + ChatColor.DARK_AQUA + "You have joined the Sniper tier.");
	                		player.setValue("gFactionsTier", "sniper");
	                		player.setValue("gFactionsTierRank", "1");
	                		Basic.setgPlayer(Basic.getgPlayer(event.getPlayer().getUniqueId().toString()), player);
	                		Blaze.invtrigger.add(event.getPlayer().getName());
	                		scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	    	                	public void run(){
	    	                		Blaze.invtrigger.remove(p.getName());
	    	                   }
	    	                }, 9L);
	                	}
	                   }
	                }, 9L);
	            }
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(0, new ItemStack(Material.STAINED_GLASS_PANE, 1), ChatColor.BOLD + "Choose wisely!", "")
    .setOption(1, new ItemStack(Material.STAINED_GLASS_PANE, 1), ChatColor.BOLD + "Choose wisely!", "")
    .setOption(2, new ItemStack(Material.STAINED_GLASS_PANE, 1), ChatColor.BOLD + "Choose wisely!", "")
    .setOption(3, new ItemStack(Material.STAINED_GLASS_PANE, 1), ChatColor.BOLD + "Choose wisely!", "")
    .setOption(4, new ItemStack(Material.ENCHANTED_BOOK, 1), ChatColor.BOLD + "" + ChatColor.AQUA +  "Switch to Sniper", ChatColor.RED + "" + ChatColor.BOLD + "Are you sure you want to switch to the sniper tier?")
    .setOption(5, new ItemStack(Material.STAINED_GLASS_PANE, 1), ChatColor.BOLD + "Choose wisely!", "")
    .setOption(6, new ItemStack(Material.STAINED_GLASS_PANE, 1), ChatColor.BOLD + "Choose wisely!", "")
    .setOption(7, new ItemStack(Material.STAINED_GLASS_PANE, 1), ChatColor.BOLD + "Choose wisely!", "")
    .setOption(8, new ItemStack(Material.STAINED_GLASS_PANE, 1), ChatColor.BOLD + "Choose wisely!", "");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
}
