package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;
import net.genesishub.gFeatures.API.Messaging.ActionAPI;
import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TierMenu {
	Statistics s = new Statistics();
	ClearInventory ci = new ClearInventory();
	ActionAPI aapi = new ActionAPI();
	
	ItemStack tierzero, tierone, tiertwo, tierthree, tierfour, sniper, shotgun, special, autorifle, kills;
	
	public TierMenu(Player p){
		tierzero = createItem(Material.IRON_BLOCK, ChatColor.AQUA + "Tier 0", ChatColor.GOLD + "Weapons in this tier costs 0 kills.");
		tierone = createItem(Material.GOLD_BLOCK, ChatColor.AQUA + "Tier 1", ChatColor.GOLD + "Weapons in this tier costs 5 kills.");
		tiertwo = createItem(Material.LAPIS_BLOCK, ChatColor.AQUA + "Tier 2", ChatColor.GOLD + "Weapons in this tier costs 10 kills.");
		tierthree = createItem(Material.DIAMOND_BLOCK, ChatColor.AQUA + "Tier 3", ChatColor.GOLD + "Weapons in this tier costs 25 kills.");
		tierfour = createItem(Material.EMERALD_BLOCK, ChatColor.AQUA + "Tier 4", ChatColor.GOLD + "Weapons in this tier costs 50 kills.");
		kills = createItem(Material.EMERALD, ChatColor.GREEN + "You have " + s.getKills(p) + " kills.", ChatColor.GOLD + " Play more to unlock more!");
		
		sniper = createItem(Material.GOLD_BLOCK, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "Sniper");
		shotgun = createItem(Material.GOLD_BLOCK, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "Shotgun");
		special = createItem(Material.GOLD_BLOCK, ChatColor.AQUA + "Special", ChatColor.GOLD + "Special");
		autorifle = createItem(Material.GOLD_BLOCK, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "Sniper");
	}
	
	public void setup(Player p){
		
		p.getInventory().setItem(0, tierzero);
		p.getInventory().setItem(1, tierone);
		p.getInventory().setItem(2, tiertwo);
		p.getInventory().setItem(3, tierthree);
		p.getInventory().setItem(4, tierfour);
		p.getInventory().setItem(8, kills);
		
		/*InventoryGUI igui = new InventoryGUI(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), "&9Gun Menu", 1)                                             
		.setItem(0, tierzero, new TierZero())
	    .setItem(1, tierone, new TierOne())
	    .setItem(2, tiertwo, new TierTwo())
	    .setItem(3, tierthree, new TierThree())
	    .setItem(4, tierfour, new TierFour())
		.setItem(8, kills, null)
		.setOpenAction(new OpenAction("HI"))
        .openInventory(p);  
		igui.openInventory(p);*/
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
		if(event.getPlayer().getItemInHand().equals(tierzero)){
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon.");
			tier(0 ,event.getPlayer());
		}
		else if(event.getPlayer().getItemInHand().equals(tierone)){
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon.");
			tier(1,event.getPlayer());
		}
		else if(event.getPlayer().getItemInHand().equals(tiertwo)){
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon.");
			tier(2,event.getPlayer());
		}
		else if(event.getPlayer().getItemInHand().equals(tierthree)){
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon.");
			tier(3,event.getPlayer());
		}
		else if(event.getPlayer().getItemInHand().equals(tierfour)){
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon.");
			tier(4,event.getPlayer());
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
			break;
		
		}
	}
}
