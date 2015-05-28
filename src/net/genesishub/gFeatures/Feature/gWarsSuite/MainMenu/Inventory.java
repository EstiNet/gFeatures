package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import org.bukkit.event.inventory.InventoryOpenEvent;

public class Inventory {
	public void prevent(InventoryOpenEvent event){
		event.setCancelled(true);
	}
	public void interact(){
		
	}
}
