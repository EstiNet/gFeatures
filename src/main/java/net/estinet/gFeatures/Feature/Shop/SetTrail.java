package net.estinet.gFeatures.Feature.Shop;

import net.estinet.gFeatures.Feature.EstiCoins.EstiCoins;
import net.estinet.gFeatures.Feature.Shop.Enums.Trails;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class SetTrail {
	public void init(Player p, Trails trail){
		//Set costs here.
		switch(trail){
		case NONE:
			Shop.playerTrail.remove(p.getUniqueId());
			Shop.playerTrail.put(p.getUniqueId(), trail.toString());
			Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
			p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Got rid of any trails.");
			break;
		case FIRE:
			if(Shop.getTrail(p.getUniqueId().toString(), trail.toString()).equalsIgnoreCase("true")){
				Shop.playerTrail.remove(p.getUniqueId());
				Shop.playerTrail.put(p.getUniqueId(), trail.toString());
				Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
				p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Equipped fire trail.");
			}
			else{
				if(EstiCoins.getMoney(p) >= 450){
					try {
						p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Bought fire trail.");
						EstiCoins.takeMoney(p, 450);
						Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
						Shop.syncCommands.set("trails-" + p.getUniqueId() + "-" + trail.toString(), "true");
						Shop.playerTrail.remove(p.getUniqueId());
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
				Shop.playerTrail.remove(p.getUniqueId());
				Shop.playerTrail.put(p.getUniqueId(), trail.toString());
				Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
				p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Equipped water trail.");
			}
			else{
				if(EstiCoins.getMoney(p) >= 450){
					try {
						p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Bought water trail.");
						EstiCoins.takeMoney(p, 450);
						Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
						Shop.syncCommands.set("trails-" + p.getUniqueId() + "-" + trail.toString(), "true");
						Shop.playerTrail.remove(p.getUniqueId());
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
		case GRAY:
			if(Shop.getTrail(p.getUniqueId().toString(), trail.toString()).equalsIgnoreCase("true")){
				Shop.playerTrail.remove(p.getUniqueId());
				Shop.playerTrail.put(p.getUniqueId(), trail.toString());
				Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
				p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Equipped grey trail.");
			}
			else{
				if(EstiCoins.getMoney(p) >= 250){
					try {
						p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Bought grey trail.");
						EstiCoins.takeMoney(p, 250);
						Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
						Shop.syncCommands.set("trails-" + p.getUniqueId() + "-" + trail.toString(), "true");
						Shop.playerTrail.remove(p.getUniqueId());
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
		case MUSIC:
			if(Shop.getTrail(p.getUniqueId().toString(), trail.toString()).equalsIgnoreCase("true")){
				Shop.playerTrail.remove(p.getUniqueId());
				Shop.playerTrail.put(p.getUniqueId(), trail.toString());
				Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
				p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Equipped music trail.");
			}
			else{
				if(EstiCoins.getMoney(p) >= 350){
					try {
						p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Bought music trail.");
						EstiCoins.takeMoney(p, 350);
						Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
						Shop.syncCommands.set("trails-" + p.getUniqueId() + "-" + trail.toString(), "true");
						Shop.playerTrail.remove(p.getUniqueId());
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
		case RAINBOW:
			if(p.hasPermission("gFeatures.Esti+")){
				Shop.playerTrail.remove(p.getUniqueId());
				Shop.playerTrail.put(p.getUniqueId(), trail.toString());
				Shop.syncCommands.set("trails-" + p.getUniqueId().toString(), trail.toString());
				p.sendMessage("[" + ChatColor.GOLD + "" + ChatColor.BOLD + "Esti" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD +"Net" + ChatColor.RESET + "]" + ChatColor.GRAY + " Equipped rainbow trail.");
			}
			else{
				p.sendMessage(ChatColor.RED + "You need Esti+ or higher!");
			}
			break;
		}

	}
}
