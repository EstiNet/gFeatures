package net.estinet.gFeatures.Feature.gMusic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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

public class MusicMenu {
	public void Initialize(Player p){
			InventoryAPI menu = makeInventory(p);
			menu.open(p);
	}
	public InventoryAPI makeInventory(final Player p){
		try{
		InventoryAPI menu = new InventoryAPI("Music Menu", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	        	final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	            if(event.getName().equals(ChatColor.GOLD+"Minecraft")){
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		InventoryAPI menu1 = minecraft(p);
	                		menu1.open(event.getPlayer());
	                   }
	                }, 9L);
	            }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento")){
	            	event.getPlayer().closeInventory();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		InventoryAPI menu1 = vexento(p);
	                		menu1.open(event.getPlayer());
	                   }
	                }, 9L);
		      }
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(0, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"Minecraft", ChatColor.WHITE+"Your classic everyday minecraft music!")
    .setOption(1, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Vexento", ChatColor.WHITE+"A great electro artist! RESOURCE PACK REQUIRED!")
    .setOption(2, new ItemStack(Material.BOAT, 1), ChatColor.GOLD+"More coming soon!", ChatColor.WHITE+"More! More! More!");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public InventoryAPI minecraft(final Player p){
		try{
		InventoryAPI menu = new InventoryAPI("Artist: Minecraft", 27, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("deprecation")
			@Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	        	if(!(Constants.listen.contains(event.getPlayer()))){
	            if(event.getName().equals(ChatColor.GOLD+"11")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.11", 50, 1);
	            	event.getPlayer().closeInventory();
	            }
	            else if(event.getName().equals(ChatColor.GOLD+"13")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.13", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"blocks")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.blocks", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"cat")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.cat", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"chirp")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.chirp", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"far")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.far", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"mall")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.mall", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"mellohi")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.mellohi", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"stal")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.stal", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"strad")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.strad", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"wait")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.wait", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"ward")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "records.ward", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            }
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(0, new ItemStack(Material.RECORD_3, 1), ChatColor.GOLD+"11", ChatColor.WHITE+"Record 11")
    .setOption(1, new ItemStack(Material.RECORD_12, 1), ChatColor.GOLD+"13", ChatColor.WHITE+"Record 13")
    .setOption(2, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"blocks", ChatColor.WHITE+"Record Blocks")
    .setOption(3, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"cat", ChatColor.WHITE+"Record Cat")
	.setOption(4, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"chirp", ChatColor.WHITE+"Record Chirp")
	.setOption(5, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"far", ChatColor.WHITE+"Record Far")
	.setOption(6, new ItemStack(Material.RECORD_8, 1), ChatColor.GOLD+"mall", ChatColor.WHITE+"Record Mall")
	.setOption(7, new ItemStack(Material.RECORD_9, 1), ChatColor.GOLD+"mellohi", ChatColor.WHITE+"Record Mellohi")
	.setOption(8, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"stal", ChatColor.WHITE+"Record Stal")
	.setOption(9, new ItemStack(Material.RECORD_11, 1), ChatColor.GOLD+"strad", ChatColor.WHITE+"Record Strad")
	.setOption(10, new ItemStack(Material.RECORD_11, 1), ChatColor.GOLD+"wait", ChatColor.WHITE+"Record Wait")
	.setOption(11, new ItemStack(Material.RECORD_12, 1), ChatColor.GOLD+"ward", ChatColor.WHITE+"Record Ward");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public InventoryAPI vexento(final Player p){
		try{
		final InventoryAPI menu = new InventoryAPI("Artist: Vexento", 36, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("deprecation")
			@Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	        	if(!(Constants.listen.contains(event.getPlayer()))){
	            if(event.getName().equals(ChatColor.GOLD+"Carl Espen-Silent Storm (Vexento Remix)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "CarlEspen-SilentStorm(VexentoRemix)", 50, 1);
	            	event.getPlayer().closeInventory();
	            }
	            else if(event.getName().equals(ChatColor.GOLD+"Kime & Vexento - Climb")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Kime & Vexento - Climb (Fixed)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Lana Del Rey - Summertime Sadness (Vexento Remix)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Lana Del Rey - Summertime Sadness (Vexento Remix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Lucas King - The Last Leaf Falls (Vexento Remix)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Lucas King - The Last Leaf Falls (Vexento Remix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Owl City - Meteor Shower (Vexento Remix)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Owl City - Meteor Shower [Vexento Remix]", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Tenmon - Distant Everyday Memories (Vexento Remix)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Tenmon - Distant Everyday Memories (Vexento Remix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Tep No - It's Alright (Vexento Remix)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Tep No - It's Alright (Vexento Remix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Adrenaline")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Adrenaline", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Affectus")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Affectus", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Amor (Original Mix)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Amor (Original Mix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Anesthesia")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Anesthesia", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Another Life (100%)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Another Life (100%)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Attention Deficit")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Attention Deficit", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Buckle Up")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Buckle Up", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Capurgana")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Capurgana", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Corallium")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Corallium", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Echo")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Echo", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Empty")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Empty", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Game Over")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Game Over", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Glow")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Glow", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Go")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Go", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Good Old Memories (ChillStep)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Good Old Memories (ChillStep)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Just go for it")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Just go for it", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Killing Machine")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Killing Machine", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Lights")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Lights", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Lonely Star (Full Track))")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Lonely Star (Full Track)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Magenta")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Magenta", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Mario's Cake (Full version)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Mario's Cake (Full version)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Masked Heroes")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Masked Heroes", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Never Give Up")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Never Give Up", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - New Colours")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - New Colours", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Occupy")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Occupy", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Particles")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Particles", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"To Next Page.")){
		           event.getPlayer().closeInventory();
		           final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	                	public void run(){
	                		InventoryAPI menu1 = vexento2(p);
	                		menu1.open(event.getPlayer());
	                   }
	                }, 9L);
		      }
	        }
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(0, new ItemStack(Material.RECORD_3, 1), ChatColor.GOLD+"Carl Espen-Silent Storm (Vexento Remix)")
    .setOption(1, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Kime & Vexento - Climb")
    .setOption(2, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"Lana Del Rey - Summertime Sadness (Vexento Remix)")
    .setOption(3, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"Lucas King - The Last Leaf Falls (Vexento Remix)")
	.setOption(4, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"Owl City - Meteor Shower (Vexento Remix)")
	.setOption(5, new ItemStack(Material.RECORD_8, 1), ChatColor.GOLD+"Tenmon - Distant Everyday Memories (Vexento Remix)")
	.setOption(6, new ItemStack(Material.RECORD_9, 1), ChatColor.GOLD+"Tep No - It's Alright (Vexento Remix)")
	.setOption(7, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"Vexento - Adrenaline")
	.setOption(8, new ItemStack(Material.RECORD_11, 1), ChatColor.GOLD+"Vexento - Affectus")
	.setOption(9, new ItemStack(Material.RECORD_12, 1), ChatColor.GOLD+"Vexento - Amor (Original Mix)")
	.setOption(10, new ItemStack(Material.RECORD_3, 1), ChatColor.GOLD+"Vexento - Anesthesia")
	.setOption(11, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Vexento - Another Life (100%)")
	.setOption(12, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"Vexento - Attention Deficit")
	.setOption(13, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"Vexento - Buckle Up")
	.setOption(14, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"Vexento - Capurganá")
	.setOption(15, new ItemStack(Material.RECORD_8, 1), ChatColor.GOLD+"Vexento - Corallium")
	.setOption(16, new ItemStack(Material.RECORD_9, 1), ChatColor.GOLD+"Vexento - Echo")
	.setOption(17, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"Vexento - Empty")
	.setOption(18, new ItemStack(Material.RECORD_11, 1), ChatColor.GOLD+"Vexento - Far Away")
	.setOption(19, new ItemStack(Material.RECORD_12, 1), ChatColor.GOLD+"Vexento - Game Over")
	.setOption(20, new ItemStack(Material.RECORD_3, 1), ChatColor.GOLD+"Vexento - Glow")
	.setOption(21, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Vexento - Go")
	.setOption(22, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"Vexento - Good Old Memories (ChillStep)")
	.setOption(23, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"Vexento - Just go for it")
	.setOption(24, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"Vexento - Killing Machine")
	.setOption(25, new ItemStack(Material.RECORD_8, 1), ChatColor.GOLD+"Vexento - Lights")
	.setOption(26, new ItemStack(Material.RECORD_9, 1), ChatColor.GOLD+"Vexento - Lonely Star (Full Track)")
	.setOption(27, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"Vexento - Magenta")
	.setOption(28, new ItemStack(Material.RECORD_11, 1), ChatColor.GOLD+"Vexento - Mario's Cake (Full version)")
	.setOption(29, new ItemStack(Material.RECORD_12, 1), ChatColor.GOLD+"Vexento - Masked Heroes")
	.setOption(30, new ItemStack(Material.RECORD_3, 1), ChatColor.GOLD+"Vexento - Never Give Up")
	.setOption(31, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Vexento - New Colours")
	.setOption(32, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"Vexento - Occupy")
	.setOption(33, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"Vexento - Particles")
	.setOption(34, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"Vexento - Pegasus")
	.setOption(35, new ItemStack(Material.SULPHUR, 1), ChatColor.GOLD+"To Next Page.");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public InventoryAPI vexento2(final Player p){
		try{
		InventoryAPI menu = new InventoryAPI("Artist: Vexento Page: 2", 36, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("deprecation")
			@Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	        	if(!(Constants.listen.contains(event.getPlayer()))){
	        	if(event.getName().equals(ChatColor.GOLD+"Vexento - Pegasus")){
	        		inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Pegasus", 50, 1);
		           event.getPlayer().closeInventory();
		      }	
	        	else if(event.getName().equals(ChatColor.GOLD+"Vexento - Pixel Party")){
	        		inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Pixel Party", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Praeclara (Chillstep Fixed)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Praeclara (Chillstep Fixed)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Raise Your Pen")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Raise Your Pen", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Return Of The Raver")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Return Of The Raver", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Revenge")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Revenge", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Sign From Above")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Sign From Above", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Smile")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Smile", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Snowflakes (2)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Snowflakes (2)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Soldiers")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Soldiers", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Sons of Norway")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Sons of Norway", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Spirit")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Spirit", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Spread Your Wings")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Spread Your Wings", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Still Standing (2)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Still Standing (2)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Sudden Urge")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Sudden Urge", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Tevo (Original Mix)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Tevo (Original Mix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - The Lone Raver")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - The Lone Raver", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - The Universe")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - The Universe", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Thirsty (NEW).")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Thirsty (NEW).", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Travelin'")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Travelin'", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Valentine")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Valentine", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - We Are One (Original)")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - We Are One (Original)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Winter")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento - Winter", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento & Micco - Move Forward")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento & Micco - Move Forward", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento & Micoo - Glitchy Love Story")){
	            	inTo(p);
	            	p.playSound(p.getLocation(), "Vexento & Micoo - Glitchy Love Story", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Back to First Page.")){
	            	event.getPlayer().closeInventory();
			           final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		            	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
		                	public void run(){
		                		InventoryAPI menu1 = vexento(p);
		                		menu1.open(event.getPlayer());
		                   }
		                }, 9L);
		      }
	        	}
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(0, new ItemStack(Material.RECORD_3, 1), ChatColor.GOLD+"Vexento - Pegasus")
    .setOption(1, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Vexento - Pixel Party")
    .setOption(2, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"Vexento - Praeclara (Chillstep Fixed)")
    .setOption(3, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"Vexento - Raise Your Pen")
	.setOption(4, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"Vexento - Return Of The Raver")
	.setOption(5, new ItemStack(Material.RECORD_8, 1), ChatColor.GOLD+"Vexento - Revenge")
	.setOption(6, new ItemStack(Material.RECORD_9, 1), ChatColor.GOLD+"Vexento - Sign From Above")
	.setOption(7, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"Vexento - Smile")
	.setOption(8, new ItemStack(Material.RECORD_11, 1), ChatColor.GOLD+"Vexento - Snowflakes (2)")
	.setOption(9, new ItemStack(Material.RECORD_12, 1), ChatColor.GOLD+"Vexento - Soldiers")
	.setOption(10, new ItemStack(Material.RECORD_3, 1), ChatColor.GOLD+"Vexento - Sons of Norway")
	.setOption(11, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Vexento - Spirit")
	.setOption(12, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"Vexento - Spread Your Wings")
	.setOption(13, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"Vexento - Still Standing (2)")
	.setOption(14, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"Vexento - Sudden Urge")
	.setOption(15, new ItemStack(Material.RECORD_8, 1), ChatColor.GOLD+"Vexento - Tevo (Original Mix)")
	.setOption(16, new ItemStack(Material.RECORD_9, 1), ChatColor.GOLD+"Vexento - The Lone Raver")
	.setOption(17, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"Vexento - The Universe")
	.setOption(18, new ItemStack(Material.RECORD_11, 1), ChatColor.GOLD+"Vexento - Thirsty (NEW).")
	.setOption(19, new ItemStack(Material.RECORD_12, 1), ChatColor.GOLD+"Vexento - Travelin'")
	.setOption(20, new ItemStack(Material.RECORD_3, 1), ChatColor.GOLD+"Vexento - Valentine")
	.setOption(21, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Vexento - We Are One (Original)")
	.setOption(22, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"Vexento - Winter")
	.setOption(23, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"Vexento & Micco - Move Forward")
	.setOption(24, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"Vexento & Micoo - Glitchy Love Story")
	.setOption(25, new ItemStack(Material.SULPHUR, 1), ChatColor.GOLD+"Back to First Page.");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public void inTo(Player p){
		Constants.listen.add(p);
		inToTwo(p);
	}
	public void inToTwo(final Player p){
		 final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
     	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
         	public void run(){
         		Constants.listen.remove(p);
            }
         }, 20L);
	}
}
