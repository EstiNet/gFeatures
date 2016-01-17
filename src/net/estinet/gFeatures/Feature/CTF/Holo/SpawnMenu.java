package net.estinet.gFeatures.Feature.CTF.Holo;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Inventory.ClearInventory;

public class SpawnMenu {
	ClearInventory ci = new ClearInventory();
	public void init(Player p){
		ci.clearInv(p);
	}
	public void interact(Player p){
		
	}
}
