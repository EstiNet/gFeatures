package net.genesishub.gFeatures.API.Inventory;

import org.bukkit.entity.Player;

public class ClearInventory {
	public void clearInv(Player p)
	{
	for(int j=0; j<38; j++)
	{
	p.getInventory().setItem(j, null);
	}
	p.getInventory().setHelmet(null);
	p.getInventory().setChestplate(null);
	p.getInventory().setLeggings(null);
	p.getInventory().setBoots(null);
	}
}
