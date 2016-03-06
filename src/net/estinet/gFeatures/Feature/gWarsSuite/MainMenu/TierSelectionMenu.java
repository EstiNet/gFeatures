package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu;

import net.estinet.gFeatures.API.Inventory.InventoryAPI;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;
import net.estinet.gFeatures.Feature.gWarsSuite.gWarsMode;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.Tiers.FourTier;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.Tiers.OneTier;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.Tiers.ThreeTier;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.Tiers.Tier;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.Tiers.TwoTier;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.Tiers.ZeroTier;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

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

public class TierSelectionMenu {
	/*Statistics s = new Statistics();
	@SuppressWarnings("rawtypes")
	Tier tier = new Tier();
	public void Initialize(PlayerInteractEvent event){
		if(s.getMode(event.getPlayer()).equals(gWarsMode.GUNMENU) && event.getPlayer().getItemInHand().getType() == Material.CHEST){
			InventoryAPI menu = makeInventory(event.getPlayer());
			menu.open(event.getPlayer());
		}
	}
	public InventoryAPI makeInventory(final Player p){
		try{
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
	            	final InventoryAPI menu1 = TierOneInventory(p);
	            	event.getPlayer().closeInventory();
	                scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		menu1.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            else if(event.getName().equals(ChatColor.AQUA+"Tier 2")){
	            	final InventoryAPI menu2 = TierTwoInventory(p);
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		menu2.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            	else if(event.getName().equals(ChatColor.AQUA+"Tier 3")){
	            	final InventoryAPI menu3 = TierThreeInventory(p);
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		menu3.open(event.getPlayer());
	                   }
	                }, 9L);
	        	}
	            	else if(event.getName().equals(ChatColor.AQUA+"Tier 4")){
	            	final InventoryAPI menu4 = TierFourInventory(p);
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
	.setOption(8, new ItemStack(Material.EMERALD, 1), ChatColor.GREEN+"You have " + s.getKills(p) + " kills.");
		return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public InventoryAPI TierZeroInventory(Player p){
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("unchecked")
			@Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		tier.sort(ZeroTier.SNIPER, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		tier.sort(ZeroTier.AUTORIFLE, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		tier.sort(ZeroTier.SHOTGUN, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		tier.sort(ZeroTier.SPECIAL, p);
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
	public InventoryAPI TierOneInventory(Player p){
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("unchecked")
			@Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		tier.sort(OneTier.SNIPER, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		tier.sort(OneTier.AUTORIFLE, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		tier.sort(OneTier.SHOTGUN, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		tier.sort(OneTier.SPECIAL, p);
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
	public InventoryAPI TierTwoInventory(Player p){
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("unchecked")
			@Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		tier.sort(TwoTier.SNIPER, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		tier.sort(TwoTier.AUTORIFLE, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		tier.sort(TwoTier.SHOTGUN, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		tier.sort(TwoTier.SPECIAL, p);
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
	public InventoryAPI TierThreeInventory(Player p){
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("unchecked")
			@Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		tier.sort(ThreeTier.SNIPER, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		tier.sort(ThreeTier.AUTORIFLE, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		tier.sort(ThreeTier.SHOTGUN, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		tier.sort(ThreeTier.SPECIAL, p);
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
	public InventoryAPI TierFourInventory(Player p){
		InventoryAPI menu = new InventoryAPI("Select Type", 9, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("unchecked")
			@Override
	        public void onOptionClick(InventoryAPI.OptionClickEvent event) {
	        	String chosen = event.getName();
	        	if(chosen.equals(ChatColor.DARK_AQUA+"Sniper")){
	        		tier.sort(FourTier.SNIPER, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Auto Rifle")){
	        		tier.sort(FourTier.AUTORIFLE, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Shotgun")){
	        		tier.sort(FourTier.SHOTGUN, p);
	        	}
	        	else if(chosen.equals(ChatColor.DARK_AQUA+"Special")){
	        		tier.sort(FourTier.SPECIAL, p);
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(1, new ItemStack(Material.WOOD_PICKAXE, 1), ChatColor.DARK_AQUA+"Sniper", ChatColor.WHITE+"Classic Sniper.")
    .setOption(2, new ItemStack(Material.WOOD_AXE, 1), ChatColor.DARK_AQUA+"Auto Rifle", ChatColor.WHITE+"Classic Auto Rifle.")
    .setOption(3, new ItemStack(Material.WOOD_SPADE, 1), ChatColor.DARK_AQUA+"Shotgun", ChatColor.WHITE+"Classic Shotgun.")
	.setOption(4, new ItemStack(Material.WOOD_SWORD, 1), ChatColor.DARK_AQUA+"Special", ChatColor.WHITE+"More health, less damage.");
	return menu;
	}*/
}
