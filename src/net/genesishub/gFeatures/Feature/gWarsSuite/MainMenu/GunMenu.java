package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GunMenu {
	public void setup(Player p){
		ClearInventory ci = new ClearInventory();
		ci.clearInv(p);
		ItemStack chest = new ItemStack(Material.CHEST, 1);
        ItemMeta im = chest.getItemMeta();
        im.setDisplayName(ChatColor.AQUA + "Select Gun");
        chest.setItemMeta(im);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		p.getInventory().setHeldItemSlot(0);
        		p.getInventory().setItemInHand(chest);	
        	}
        }, 20L);
        
	}
	public void interaction(PlayerInteractEvent event){
		TierMenu tm = new TierMenu(event.getPlayer());
		tm.setup(event.getPlayer());
	}
}
