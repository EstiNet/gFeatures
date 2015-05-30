package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;

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
        p.getInventory().setHeldItemSlot(0);
        p.getInventory().setItemInHand(chest);
	}
	public void interaction(PlayerInteractEvent event){
		TierSelectionMenu tsm = new TierSelectionMenu();
		tsm.Initialize(event);
	}
}
