package net.estinet.gFeatures.Feature.SurvivalTwo.Menus;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Inventory.InventoryAPI.OptionClickEvent;

public abstract class MenuRunnable implements Runnable{
	Player p = null;
	OptionClickEvent event = null;
	public abstract void run();
}
