package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class GunMenu {
	public void setup(Player p){
		ClearInventory ci = new ClearInventory();
		ci.clearInv(p);
		
	}
	public void interaction(PlayerInteractEvent event){
		TierSelectionMenu tsm = new TierSelectionMenu();
		tsm.Initialize(event);
	}
}
