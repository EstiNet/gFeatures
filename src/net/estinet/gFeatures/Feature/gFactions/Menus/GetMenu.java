package net.estinet.gFeatures.Feature.gFactions.Menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Feature.gFactions.Blaze;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;

public class GetMenu {
	net.estinet.gFeatures.Feature.gFactions.Menus.Autorifle.Beginner autorifle = new net.estinet.gFeatures.Feature.gFactions.Menus.Autorifle.Beginner();
	public void start(PlayerInteractEntityEvent event){
		Bukkit.getLogger().info(event.getPlayer().getUniqueId().toString());
		Bukkit.getLogger().info(event.getRightClicked().getUniqueId().toString());
		Bukkit.getLogger().info(Blaze.autorifles.toString());
		if(event.getRightClicked().getUniqueId().equals(Blaze.autorifles)){
			Bukkit.getLogger().info(Basic.getgPlayer(event.getPlayer().getUniqueId().toString()).getValue("gFactionsTier"));
			if(!(Basic.getgPlayer(event.getPlayer().getUniqueId().toString()).getValue("gFactionsTier").equals("autorifle"))){
				autorifle.makeInventory(event.getPlayer(), Basic.getgPlayer(event.getPlayer().getUniqueId().toString()));
			}
		}
		else if(event.getRightClicked().getUniqueId().equals(Blaze.shotguns)){
			
		}
		else if(event.getRightClicked().getUniqueId().equals(Blaze.snipers)){
			
		}
	}
	public void start(EntityDamageByEntityEvent event){
		Player pl = (Player) event.getDamager();
		Bukkit.getLogger().info(pl.getUniqueId().toString());
		Bukkit.getLogger().info(event.getEntity().getUniqueId().toString());
		Bukkit.getLogger().info(Blaze.autorifles.toString());
		if(event.getEntity().getUniqueId().toString().equals(Blaze.autorifles.toString())){
			Bukkit.getLogger().info(Basic.getgPlayer(pl.getUniqueId().toString()).getValue("gFactionsTier"));
			if(!(Basic.getgPlayer(pl.getUniqueId().toString()).getValue("gFactionsTier").equals("autorifle"))){
				InventoryAPI iapi = autorifle.makeInventory(pl, Basic.getgPlayer(pl.getUniqueId().toString()));
				iapi.open(pl);
			}
		}
		else if(event.getEntity().getUniqueId().toString().equals(Blaze.shotguns.toString())){
			
		}
		else if(event.getEntity().getUniqueId().toString().equals(Blaze.snipers.toString())){
			
		}
	}
}
