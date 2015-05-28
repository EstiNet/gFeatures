package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Inventory {
	ItemStack item1, item2;
	public Inventory(){
		ItemStack items = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.CREEPER.ordinal());
		SkullMeta item1meta = (SkullMeta) items.getItemMeta();
		item1meta.setDisplayName(ChatColor.GOLD + "Singleplayer");
		items.setItemMeta(item1meta);
		item1 = items;
	}
	public void prevent(InventoryOpenEvent event){
		event.setCancelled(true);
	}
	public void interact(PlayerInteractEvent event){
		
		if((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_AIR))){
			if(event.getPlayer().getItemInHand().equals(item1)){
				
			}
		}
	}
}
