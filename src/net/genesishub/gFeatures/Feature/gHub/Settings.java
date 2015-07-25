package net.genesishub.gFeatures.Feature.gHub;

import net.genesishub.gFeatures.Feature.gWarsSuiteOld.InventoryAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Settings {
	public void init(Player p){
		
	}
	public InventoryAPI makeInventory(final Player p){
		try{
		InventoryAPI menu = new InventoryAPI(ChatColor.GRAY + "Settings", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	            if(event.getName().equals(ChatColor.GOLD+" ")){
	            	
	            }
	            else if(event.getName().equals(ChatColor.GOLD+" ")){
		            
		           event.getPlayer().closeInventory();
		      }
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(0, new ItemStack(Material.MINECART, 1), ChatColor.GOLD+"Summon Airplane", ChatColor.WHITE+"Stand on an airfield!")
    .setOption(1, new ItemStack(Material.MINECART, 1), ChatColor.GOLD+"Summon Anti Aircraft Guns", ChatColor.WHITE+"Stand close to an Anti-Aircraft Station!")
    .setOption(2, new ItemStack(Material.BOAT, 1), ChatColor.GOLD+"Summon Boat", ChatColor.WHITE+"Stand on a docks!");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
}
