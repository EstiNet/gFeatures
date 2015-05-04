package net.genesishub.gFeatures.Feature.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierFour;
import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierOne;
import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierThree;
import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierTwo;
import tk.genesishub.gFeatures.gWarsSuite.Tiers.TierZero;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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

public class TierSelectionMenu {
	public void Initialize(PlayerInteractEvent event){
		if(!(Constants.gunin.contains(event.getPlayer().getName())) && event.getPlayer().getItemInHand().getType() == Material.CHEST){
			InventoryAPI menu = makeInventory(event.getPlayer());
			Bukkit.getServer().getLogger().info(event.getPlayer().getName());
			menu.open(event.getPlayer());
			Bukkit.getLogger().info("HI");
		}
	}
	public InventoryAPI test(Player p){
		StatsRetrieve sr = new StatsRetrieve();
		InventoryAPI menu = new InventoryAPI("My Fancy Menu", 9, new InventoryAPI.OptionClickEventHandler() {
            @Override
            public void onOptionClick(InventoryAPI.OptionClickEvent event) {
                event.getPlayer().sendMessage("You have chosen " + event.getName());
                event.setWillClose(true);
            }
        }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
		.setOption(1, new ItemStack(Material.IRON_BLOCK, 1), ChatColor.AQUA + "Tier 0", ChatColor.GOLD+"Weapons here cost 0 kills.")
	    .setOption(2, new ItemStack(Material.GOLD_BLOCK, 1), ChatColor.AQUA+"Tier 1", ChatColor.GOLD+"Weapons here cost 5 kills.")
	    .setOption(3, new ItemStack(Material.LAPIS_BLOCK, 1), ChatColor.AQUA+"Tier 2", ChatColor.GOLD+"Weapons here cost 10 kills.")
	    .setOption(4, new ItemStack(Material.DIAMOND_BLOCK, 1), "Tier 3", ChatColor.GOLD+"Weapons here cost 25 kills.")
	    .setOption(5, new ItemStack(Material.EMERALD_BLOCK, 1), "Tier 4", ChatColor.GOLD+"Weapons here cost 50 kills.")
		.setOption(8, new ItemStack(Material.EMERALD, 1), ChatColor.GREEN+"You have " + Integer.toString(sr.getKills(p.getName())) + " kills.");
		return menu;
	}
	public InventoryAPI makeInventory(final Player p){
		try{
		StatsRetrieve sr = new StatsRetrieve();
		final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		InventoryAPI menu = new InventoryAPI("Select Tier", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	            if(event.getName().equals(ChatColor.AQUA+"Tier 0")){
	            	final InventoryAPI menus = TierZeroInventory(p);
	            	event.getPlayer().closeInventory();
	                scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		menus.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            else if(event.getName().equals(ChatColor.AQUA+"Tier 1")){
	            	final InventoryAPI menu1 = TierOneInventory();
	            	event.getPlayer().closeInventory();
	                scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		menu1.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            else if(event.getName().equals(ChatColor.AQUA+"Tier 2")){
	            	final InventoryAPI menu2 = TierTwoInventory();
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		menu2.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            	else if(event.getName().equals(ChatColor.AQUA+"Tier 3")){
	            	final InventoryAPI menu3 = TierThreeInventory();
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		menu3.open(event.getPlayer());
	                   }
	                }, 9L);
	        	}
	            	else if(event.getName().equals(ChatColor.AQUA+"Tier 4")){
	            	final InventoryAPI menu4 = TierFourInventory();
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		menu4.open(event.getPlayer());
	                   }
	                }, 9L);
	            	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(0, new ItemStack(Material.IRON_BLOCK, 1), ChatColor.AQUA+"Tier 0", ChatColor.GOLD+"Weapons here cost 0 kills.")
    .setOption(1, new ItemStack(Material.GOLD_BLOCK, 1), ChatColor.AQUA+"Tier 1", ChatColor.GOLD+"Weapons here cost 5 kills.")
    .setOption(2, new ItemStack(Material.LAPIS_BLOCK, 1), ChatColor.AQUA+"Tier 2", ChatColor.GOLD+"Weapons here cost 10 kills.")
    .setOption(3, new ItemStack(Material.DIAMOND_BLOCK, 1), ChatColor.AQUA+"Tier 3", ChatColor.GOLD+"Weapons here cost 25 kills.")
    .setOption(4, new ItemStack(Material.EMERALD_BLOCK, 1), ChatColor.AQUA+"Tier 4", ChatColor.GOLD+"Weapons here cost 50 kills.")
	.setOption(8, new ItemStack(Material.EMERALD, 1), ChatColor.GREEN+"You have " + sr.getKills(p.getName()) + " kills.");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public InventoryAPI TierZeroInventory(Player p){
		final KitManagerHub kmh = new KitManagerHub();
		final Command cmd = null;
		final String label = "";
		final String[] args = {"hi"};
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier0-sniper");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier0-auto-rifle");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier0-shotgun");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier0-special");
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"Classic Sniper.")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"Classic Auto Rifle.")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Classic Shotgun.")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"More health, less damage.");
	return menu;
	}
	public InventoryAPI TierOneInventory(){
		final KitManagerHub kmh = new KitManagerHub();
		final Command cmd = null;
		final String label = "";
		final String[] args = {"hi"};
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier1-sniper");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier1-auto-rifle");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier1-shotgun");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier1-special");
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"ULR338")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"m16")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Colt Model 1")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"Bazooka");
	return menu;
	}
	public InventoryAPI TierTwoInventory(){
		final KitManagerHub kmh = new KitManagerHub();
		final Command cmd = null;
		final String label = "";
		final String[] args = {"hi"};
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier2-sniper");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier2-auto-rifle");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier2-shotgun");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier2-special");
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"SilSil69")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"AK47-Black Edition")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"SPAS")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"Flamethrower");
	return menu;
	}
	public InventoryAPI TierThreeInventory(){
		final KitManagerHub kmh = new KitManagerHub();
		final Command cmd = null;
		final String label = "";
		final String[] args = {"hi"};
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier3-sniper");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier3-auto-rifle");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier3-shotgun");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier3-special");
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"Classic Sniper.")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"Classic Auto Rifle.")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Classic Shotgun.")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"More health, less damage.");
	return menu;
	}
	public InventoryAPI TierFourInventory(){
		final KitManagerHub kmh = new KitManagerHub();
		final Command cmd = null;
		final String label = "";
		final String[] args = {"hi"};
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier4-sniper");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier4-auto-rifle");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier4-shotgun");
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		kmh.Organize((CommandSender)event.getPlayer(), cmd, label, args, "tier4-special");
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"Classic Sniper.")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"Classic Auto Rifle.")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Classic Shotgun.")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"More health, less damage.");
	return menu;
	}
}
