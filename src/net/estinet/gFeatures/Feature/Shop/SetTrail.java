package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.GenesisEconomy.MoneyManager;
import net.estinet.gFeatures.Feature.Shop.Enums.Trails;
import net.md_5.bungee.api.ChatColor;

public class SetTrail {
	public void init(Player p, Trails trail){
		//Set costs here.
		switch(trail){
		case NONE:
			Shop.playerTrail.remove(p.getUniqueId().toString());
			Shop.playerTrail.put(p.getUniqueId(), trail.toString());
			Shop.syncCommands.set("trail-" + p.getUniqueId().toString(), trail.toString());
			break;
		case FIRE:
			if(Shop.getTrail(p.getUniqueId().toString(), trail.toString())){
				Shop.playerTrail.remove(p.getUniqueId().toString());
				Shop.playerTrail.put(p.getUniqueId(), trail.toString());
				Shop.syncCommands.set("trail-" + p.getUniqueId().toString(), trail.toString());
			}
			else{
				MoneyManager mm = new MoneyManager();
				if(mm.getMoney(p) >= 450){
					
				}
				else{
					p.sendMessage(ChatColor.RED + "Not enough money!");
				}
			}
			break;
		}

	}
}
