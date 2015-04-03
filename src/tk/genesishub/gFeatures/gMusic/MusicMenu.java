package tk.genesishub.gFeatures.gMusic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

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
    .setOption(0, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"Minecraft", ChatColor.WHITE+"Your classic everyday C418 music!")
    .setOption(1, new ItemStack(Material.RECORD_4, 1), ChatColor.GOLD+"Vexento", ChatColor.WHITE+"A great electro artist!")
    .setOption(2, new ItemStack(Material.BOAT, 1), ChatColor.GOLD+"More coming soon!", ChatColor.WHITE+"More! More! More!");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
	public InventoryAPI minecraft(final Player p){
		try{
		InventoryAPI menu = new InventoryAPI("Artist: Minecraft", 18, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("deprecation")
			@Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	            if(event.getName().equals(ChatColor.GOLD+"11")){
	            	p.playSound(p.getLocation(), "records.11", 50, 1);
	            	event.getPlayer().closeInventory();
	            }
	            else if(event.getName().equals(ChatColor.GOLD+"13")){
	            	p.playSound(p.getLocation(), "records.13", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"blocks")){
	            	p.playSound(p.getLocation(), "records.blocks", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"cat")){
	            	p.playSound(p.getLocation(), "records.cat", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"chirp")){
	            	p.playSound(p.getLocation(), "records.chirp", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"far")){
	            	p.playSound(p.getLocation(), "records.far", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"mall")){
	            	p.playSound(p.getLocation(), "records.mall", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"mellohi")){
	            	p.playSound(p.getLocation(), "records.mellohi", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"stal")){
	            	p.playSound(p.getLocation(), "records.stal", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"strad")){
	            	p.playSound(p.getLocation(), "records.strad", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"wait")){
	            	p.playSound(p.getLocation(), "records.wait", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"ward")){
	            	p.playSound(p.getLocation(), "records.ward", 50, 1);
		           event.getPlayer().closeInventory();
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
		InventoryAPI menu = new InventoryAPI("Artist: Vexento", 27, new InventoryAPI.OptionClickEventHandler() {
	        @SuppressWarnings("deprecation")
			@Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	            if(event.getName().equals(ChatColor.GOLD+"Carl Espen-Silent Storm (Vexento Remix)")){
	            	p.playSound(p.getLocation(), "CarlEspen-SilentStorm(VexentoRemix)", 50, 1);
	            	event.getPlayer().closeInventory();
	            }
	            else if(event.getName().equals(ChatColor.GOLD+"Kime & Vexento - Climb")){
	            	p.playSound(p.getLocation(), "Kime & Vexento - Climb (Fixed)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Lana Del Rey - Summertime Sadness (Vexento Remix)")){
	            	p.playSound(p.getLocation(), "Lana Del Rey - Summertime Sadness (Vexento Remix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Lucas King - The Last Leaf Falls (Vexento Remix)")){
	            	p.playSound(p.getLocation(), "Lucas King - The Last Leaf Falls (Vexento Remix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Owl City - Meteor Shower (Vexento Remix)")){
	            	p.playSound(p.getLocation(), "Owl City - Meteor Shower [Vexento Remix]", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Tenmon - Distant Everyday Memories (Vexento Remix)")){
	            	p.playSound(p.getLocation(), "Tenmon - Distant Everyday Memories (Vexento Remix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Tep No - It's Alright (Vexento Remix)")){
	            	p.playSound(p.getLocation(), "Tep No - It's Alright (Vexento Remix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Adrenaline")){
	            	p.playSound(p.getLocation(), "Vexento - Adrenaline", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Affectus")){
	            	p.playSound(p.getLocation(), "Vexento - Affectus", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Amor (Original Mix)")){
	            	p.playSound(p.getLocation(), "Vexento - Amor (Original Mix)", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Anesthesia")){
	            	p.playSound(p.getLocation(), "Vexento - Anesthesia", 50, 1);
		           event.getPlayer().closeInventory();
		      }
	            else if(event.getName().equals(ChatColor.GOLD+"Vexento - Another Life (100%)")){
	            	p.playSound(p.getLocation(), "Vexento - Another Life (100%)", 50, 1);
		           event.getPlayer().closeInventory();
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
	.setOption(12, new ItemStack(Material.RECORD_5, 1), ChatColor.GOLD+"ward")
	.setOption(13, new ItemStack(Material.RECORD_6, 1), ChatColor.GOLD+"ward")
	.setOption(14, new ItemStack(Material.RECORD_7, 1), ChatColor.GOLD+"ward")
	.setOption(15, new ItemStack(Material.RECORD_8, 1), ChatColor.GOLD+"ward")
	.setOption(16, new ItemStack(Material.RECORD_9, 1), ChatColor.GOLD+"ward")
	.setOption(17, new ItemStack(Material.RECORD_10, 1), ChatColor.GOLD+"ward")
	.setOption(18, new ItemStack(Material.RECORD_11, 1), ChatColor.GOLD+"ward");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
}
