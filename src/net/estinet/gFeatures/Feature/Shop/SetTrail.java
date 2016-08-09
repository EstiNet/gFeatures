package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;
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
			Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
			p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Got rid of any trails.");
			break;
		case FIRE:
			if(Shop.getTrail(p.getUniqueId().toString(), trail.toString()).equalsIgnoreCase("true")){
				Shop.playerTrail.remove(p.getUniqueId().toString());
				Shop.playerTrail.put(p.getUniqueId(), trail.toString());
				Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
				p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Equipped fire trail.");
			}
			else{
				MoneyManager mm = new MoneyManager();
				if(mm.getMoney(p) >= 450){
					try {
						p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Bought fire trail.");
						mm.takeMoney(p, 450);
						Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
						Shop.syncCommands.set("trails-" + p.getUniqueId() + "-" + trail.toString(), "true");
						Shop.playerTrail.remove(p.getUniqueId().toString());
						Shop.playerTrail.put(p.getUniqueId(), trail.toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					p.sendMessage(ChatColor.RED + "Not enough money!");
				}
			}
			break;
		case WATER:
			if(Shop.getTrail(p.getUniqueId().toString(), trail.toString()).equalsIgnoreCase("true")){
				Shop.playerTrail.remove(p.getUniqueId().toString());
				Shop.playerTrail.put(p.getUniqueId(), trail.toString());
				Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
				p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Equipped water trail.");
			}
			else{
				MoneyManager mm = new MoneyManager();
				if(mm.getMoney(p) >= 450){
					try {
						p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Bought water trail.");
						mm.takeMoney(p, 450);
						Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
						Shop.syncCommands.set("trails-" + p.getUniqueId() + "-" + trail.toString(), "true");
						Shop.playerTrail.remove(p.getUniqueId().toString());
						Shop.playerTrail.put(p.getUniqueId(), trail.toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					p.sendMessage(ChatColor.RED + "Not enough money!");
				}
			}
			break;
		}

	}
}
