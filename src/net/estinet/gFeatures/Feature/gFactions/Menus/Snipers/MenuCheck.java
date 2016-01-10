package net.estinet.gFeatures.Feature.gFactions.Menus.Snipers;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.API.Inventory.InventoryAPI;

public class MenuCheck {
	TierOne to = new TierOne();
	TierTwo tt = new TierTwo();
	TierThree tth = new TierThree();
	TierFour tf = new TierFour();
	public void check(Player p){
		if((Basic.getgPlayer(p.getUniqueId().toString()).getValue("gFactionsTier").equals("1"))){
			InventoryAPI iapi = TierOne.makeInventory(p, Basic.getgPlayer(p.getUniqueId().toString()));
			iapi.open(p);
		}
		else if((Basic.getgPlayer(p.getUniqueId().toString()).getValue("gFactionsTier").equals("1"))){
			InventoryAPI iapi = TierTwo.makeInventory(p, Basic.getgPlayer(p.getUniqueId().toString()));
			iapi.open(p);
		}
		else if((Basic.getgPlayer(p.getUniqueId().toString()).getValue("gFactionsTier").equals("1"))){
			InventoryAPI iapi = TierThree.makeInventory(p, Basic.getgPlayer(p.getUniqueId().toString()));
			iapi.open(p);
		}
		else if((Basic.getgPlayer(p.getUniqueId().toString()).getValue("gFactionsTier").equals("1"))){
			InventoryAPI iapi = TierFour.makeInventory(p, Basic.getgPlayer(p.getUniqueId().toString()));
			iapi.open(p);
		}
	}
}
