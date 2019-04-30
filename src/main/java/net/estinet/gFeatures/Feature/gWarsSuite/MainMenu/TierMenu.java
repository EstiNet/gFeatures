package net.estinet.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.gWarsSuite.Statistics;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierFour;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierOne;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierThree;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierTwo;
import net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierZero;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

public class TierMenu {
	Statistics s = new Statistics();
	ClearInventory ci = new ClearInventory();

	ItemStack tierzero, tierone, tiertwo, tierthree, tierfour, sniper, shotgun, special, autorifle, sniper1, shotgun1, special1, autorifle1, 
	sniper2, shotgun2, special2, autorifle2, sniper3, shotgun3, special3, autorifle3, sniper4, shotgun4, special4, autorifle4, cancel, kills;
	
	List<String> dump = new ArrayList<>();
	List<ItemStack> all = new ArrayList<>();
	
	public TierMenu(Player p){
		cancel = createItem(Material.BARRIER, ChatColor.RED + "Back");
		
		tierzero = createItem(Material.IRON_BLOCK, ChatColor.AQUA + "Tier 0", ChatColor.GOLD + "This tier requires 0 kills.");
		tierone = createItem(Material.GOLD_BLOCK, ChatColor.AQUA + "Tier 1", ChatColor.GOLD + "This tier requires 5 kills.");
		tiertwo = createItem(Material.LAPIS_BLOCK, ChatColor.AQUA + "Tier 2", ChatColor.GOLD + "This tier requires 10 kills.");
		tierthree = createItem(Material.DIAMOND_BLOCK, ChatColor.AQUA + "Tier 3", ChatColor.GOLD + "This tier requires 25 kills.");
		tierfour = createItem(Material.EMERALD_BLOCK, ChatColor.AQUA + "Tier 4", ChatColor.GOLD + "This tier requires 50 kills.");
		kills = createItem(Material.EMERALD, ChatColor.GREEN + "You have " + s.getKills(p) + " kills.", ChatColor.GOLD + " Play to earn more kills!");
		
		sniper = createItem(Material.WOODEN_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "Sniper");
		shotgun = createItem(Material.WOODEN_SHOVEL, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "Shotgun");
		special = createItem(Material.WOODEN_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Crossbow");
		autorifle = createItem(Material.WOODEN_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "Auto-Rifle");
		
		sniper1 = createItem(Material.STONE_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "ULR338");
		shotgun1 = createItem(Material.STONE_SHOVEL, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "Colt Model 1");
		special1 = createItem(Material.STONE_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Rocket Launcher");
		autorifle1 = createItem(Material.STONE_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "m16");
		
		sniper2 = createItem(Material.GOLDEN_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "SilSil69");
		shotgun2 = createItem(Material.GOLDEN_SHOVEL, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "SPAS Regular");
		special2 = createItem(Material.GOLDEN_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Flamethrower");
		autorifle2 = createItem(Material.GOLDEN_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "AK47 Silver");

		sniper3 = createItem(Material.IRON_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "SR-25");
		shotgun3 = createItem(Material.IRON_SHOVEL, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "FN-TPS");
		special3 = createItem(Material.IRON_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Assassin");
		autorifle3 = createItem(Material.IRON_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "Beretta ARX100");
		
		sniper4 = createItem(Material.DIAMOND_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "C14 Timberwolf");
		shotgun4 = createItem(Material.DIAMOND_SHOVEL, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "SPAS-12");
		special4 = createItem(Material.DIAMOND_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Strike Team");
		autorifle4 = createItem(Material.DIAMOND_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "Heckler and Koch MP-5");	
		
		all.add(sniper);
		all.add(shotgun);
		all.add(special);
		all.add(autorifle);
		all.add(sniper1);
		all.add(shotgun1);
		all.add(special1);
		all.add(autorifle1);
		all.add(sniper2);
		all.add(shotgun3);
		all.add(special2);
		all.add(autorifle2);
		all.add(sniper3);
		all.add(shotgun3);
		all.add(special3);
		all.add(autorifle3);
		all.add(sniper4);
		all.add(shotgun4);
		all.add(special4);
		all.add(autorifle4);
		all.add(cancel);
	}
	
	public void setup(Player p){
		ci.clearInv(p);
		
		p.getInventory().setItem(0, tierzero);
		p.getInventory().setItem(1, tierone);
		p.getInventory().setItem(2, tiertwo);
		p.getInventory().setItem(3, tierthree);
		p.getInventory().setItem(4, tierfour);
		p.getInventory().setItem(8, kills);
		
	}
	
	public ItemStack createItem(Material material, String name, String ... lore){
		ItemStack item = new ItemStack(material, 1);
		List<String> lores = new ArrayList<>();
		for(String lor : lore){
		lores.add(lor);
		}
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lores);
		item.setItemMeta(meta);
		return item;
	}
	
	public void interact(PlayerInteractEvent event){
		if(event.getPlayer().getInventory().getItemInMainHand().equals(tierzero)){
			event.getPlayer().sendActionBar(ChatColor.AQUA + "Please select a weapon.");
			tier(0 ,event.getPlayer());
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(tierone)){
			event.getPlayer().sendActionBar(ChatColor.AQUA + "Please select a weapon. You will need 5 kills for this tier.");
			tier(1,event.getPlayer());
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(tiertwo)){
			event.getPlayer().sendActionBar(ChatColor.AQUA + "Please select a weapon. You will need 10 kills for this tier.");
			tier(2,event.getPlayer());
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(tierthree)){
			event.getPlayer().sendActionBar(ChatColor.AQUA + "Please select a weapon. You will need 25 kills for this tier.");
			tier(3,event.getPlayer());
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(tierfour)){
			event.getPlayer().sendActionBar(ChatColor.AQUA + "Please select a weapon. You will need 50 kills for this tier.");
			tier(4,event.getPlayer());
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(sniper) || event.getPlayer().getInventory().getItemInMainHand().equals(shotgun) || event.getPlayer().getInventory().getItemInMainHand().equals(special) || event.getPlayer().getInventory().getItemInMainHand().equals(autorifle)){
			TierZero tz = new TierZero(event.getPlayer());
			tz.interact(event);				
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(sniper1) || event.getPlayer().getInventory().getItemInMainHand().equals(shotgun1) || event.getPlayer().getInventory().getItemInMainHand().equals(special1) || event.getPlayer().getInventory().getItemInMainHand().equals(autorifle1)){
			if(s.getKills(event.getPlayer()) >= 5){
			TierOne to = new TierOne(event.getPlayer());
			to.interact(event);
			}
			else{
				aww(event.getPlayer(), "5");
			}
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(sniper2) || event.getPlayer().getInventory().getItemInMainHand().equals(shotgun2) || event.getPlayer().getInventory().getItemInMainHand().equals(special2) || event.getPlayer().getInventory().getItemInMainHand().equals(autorifle2)){
			if(s.getKills(event.getPlayer()) >= 10){
			TierTwo to = new TierTwo(event.getPlayer());
			to.interact(event);
			}
			else{
				aww(event.getPlayer(), "10");
			}
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(sniper3) || event.getPlayer().getInventory().getItemInMainHand().equals(shotgun3) || event.getPlayer().getInventory().getItemInMainHand().equals(special3) || event.getPlayer().getInventory().getItemInMainHand().equals(autorifle3)){
			if(s.getKills(event.getPlayer()) >= 25){
			TierThree to = new TierThree(event.getPlayer());
			to.interact(event);
			}
			else{
				aww(event.getPlayer(), "25");
			}
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(sniper4) || event.getPlayer().getInventory().getItemInMainHand().equals(shotgun4) || event.getPlayer().getInventory().getItemInMainHand().equals(special4) || event.getPlayer().getInventory().getItemInMainHand().equals(autorifle4)){
			if(s.getKills(event.getPlayer()) >= 50){
			TierFour to = new TierFour(event.getPlayer());
			to.interact(event);
			}
			else{
				aww(event.getPlayer(), "50");
			}
		}
		else if(event.getPlayer().getInventory().getItemInMainHand().equals(cancel)){
			setup(event.getPlayer());
		}
	}
	
	public void tier(int tier, Player p){
		ci.clearInv(p);
		switch(tier){
		case 0:
			p.getInventory().setItem(0, sniper);
			p.getInventory().setItem(1, shotgun);
			p.getInventory().setItem(2, autorifle);
			p.getInventory().setItem(3, special);
			p.getInventory().setItem(8, cancel);
			break;
		case 1:
			p.getInventory().setItem(0, sniper1);
			p.getInventory().setItem(1, shotgun1);
			p.getInventory().setItem(2, autorifle1);
			p.getInventory().setItem(3, special1);
			p.getInventory().setItem(8, cancel);
			break;
		case 2:
			p.getInventory().setItem(0, sniper2);
			p.getInventory().setItem(1, shotgun2);
			p.getInventory().setItem(2, autorifle2);
			p.getInventory().setItem(3, special2);
			p.getInventory().setItem(8, cancel);
			break;
		case 3:
			p.getInventory().setItem(0, sniper3);
			p.getInventory().setItem(1, shotgun3);
			p.getInventory().setItem(2, autorifle3);
			p.getInventory().setItem(3, special3);
			p.getInventory().setItem(8, cancel);
			break;
		case 4:
			p.getInventory().setItem(0, sniper4);
			p.getInventory().setItem(1, shotgun4);
			p.getInventory().setItem(2, autorifle4);
			p.getInventory().setItem(3, special4);
			p.getInventory().setItem(8, cancel);
			break;
		}
	}
	public void aww(Player p, String message){
		p.sendMessage(ChatColor.GRAY + "[Guns] Awww... You don't have enough kills! " + ChatColor.WHITE + "" + message + " kills are required for this tier!");
	}
}
