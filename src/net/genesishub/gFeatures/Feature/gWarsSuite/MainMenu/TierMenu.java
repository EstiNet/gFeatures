package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;
import net.genesishub.gFeatures.API.Messaging.ActionAPI;
import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierFour;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierOne;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierThree;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierTwo;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Kits.TierZero;

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
	
	ItemStack tierzero, tierone, tiertwo, tierthree, tierfour, sniper, shotgun, special, autorifle, sniper1, shotgun1, special1, autorifle1, 
	sniper2, shotgun2, special2, autorifle2, sniper3, shotgun3, special3, autorifle3, sniper4, shotgun4, special4, autorifle4, cancel, kills;
	
	List<String> dump = new ArrayList<>();
	List<ItemStack> all = new ArrayList<>();
	
	public TierMenu(Player p){
		cancel = createItem(Material.BARRIER, ChatColor.RED + "Back");
		
		tierzero = createItem(Material.IRON_BLOCK, ChatColor.AQUA + "Tier 0", ChatColor.GOLD + "Weapons in this tier costs 0 kills.");
		tierone = createItem(Material.GOLD_BLOCK, ChatColor.AQUA + "Tier 1", ChatColor.GOLD + "Weapons in this tier costs 5 kills.");
		tiertwo = createItem(Material.LAPIS_BLOCK, ChatColor.AQUA + "Tier 2", ChatColor.GOLD + "Weapons in this tier costs 10 kills.");
		tierthree = createItem(Material.DIAMOND_BLOCK, ChatColor.AQUA + "Tier 3", ChatColor.GOLD + "Weapons in this tier costs 25 kills.");
		tierfour = createItem(Material.EMERALD_BLOCK, ChatColor.AQUA + "Tier 4", ChatColor.GOLD + "Weapons in this tier costs 50 kills.");
		kills = createItem(Material.EMERALD, ChatColor.GREEN + "You have " + s.getKills(p) + " kills.", ChatColor.GOLD + " Play more to unlock more!");
		
		sniper = createItem(Material.WOOD_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "Sniper");
		shotgun = createItem(Material.WOOD_SPADE, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "Shotgun");
		special = createItem(Material.WOOD_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Armoured");
		autorifle = createItem(Material.WOOD_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "Auto-Rifle");
		
		sniper1 = createItem(Material.STONE_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "ULR338");
		shotgun1 = createItem(Material.STONE_SPADE, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "Colt Model 1");
		special1 = createItem(Material.STONE_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Rocket Launcher");
		autorifle1 = createItem(Material.STONE_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "m16");
		
		sniper2 = createItem(Material.GOLD_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "SilSil69");
		shotgun2 = createItem(Material.GOLD_SPADE, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "SPAS Regular");
		special2 = createItem(Material.GOLD_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Flamethrower");
		autorifle2 = createItem(Material.GOLD_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "AK47 Silver");

		sniper3 = createItem(Material.IRON_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "SR-25");
		shotgun3 = createItem(Material.IRON_SPADE, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "FN-TPS");
		special3 = createItem(Material.IRON_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Assassin");
		autorifle3 = createItem(Material.IRON_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "Beretta ARX100");
		
		sniper4 = createItem(Material.DIAMOND_PICKAXE, ChatColor.AQUA + "Sniper", ChatColor.GOLD + "Heckler and Koch MP-4");
		shotgun4 = createItem(Material.DIAMOND_SPADE, ChatColor.AQUA + "Shotgun", ChatColor.GOLD + "SPAS-12");
		special4 = createItem(Material.DIAMOND_HOE, ChatColor.AQUA + "Special", ChatColor.GOLD + "Strike Team");
		autorifle4 = createItem(Material.DIAMOND_AXE, ChatColor.AQUA + "Auto-Rifle", ChatColor.GOLD + "m16-Elite");
		
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
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon. You will need 5 kills for this tier.");
			tier(1,event.getPlayer());
		}
		else if(event.getPlayer().getItemInHand().equals(tiertwo)){
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon. You will need 10 kills for this tier.");
			tier(2,event.getPlayer());
		}
		else if(event.getPlayer().getItemInHand().equals(tierthree)){
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon. You will need 25 kills for this tier.");
			tier(3,event.getPlayer());
		}
		else if(event.getPlayer().getItemInHand().equals(tierfour)){
			aapi.sendActionbar(event.getPlayer(), ChatColor.AQUA + "Please select a weapon. You will need 50 kills for this tier.");
			tier(4,event.getPlayer());
		}
		else if(event.getPlayer().getItemInHand().equals(sniper) || event.getPlayer().getItemInHand().equals(shotgun) || event.getPlayer().getItemInHand().equals(special) || event.getPlayer().getItemInHand().equals(autorifle)){
			TierZero tz = new TierZero(event.getPlayer());
			tz.interact(event);				
		}
		else if(event.getPlayer().getItemInHand().equals(sniper1) || event.getPlayer().getItemInHand().equals(shotgun1) || event.getPlayer().getItemInHand().equals(special1) || event.getPlayer().getItemInHand().equals(autorifle1)){
			TierOne to = new TierOne(event.getPlayer());
			to.interact(event);
		}
		else if(event.getPlayer().getItemInHand().equals(sniper2) || event.getPlayer().getItemInHand().equals(shotgun2) || event.getPlayer().getItemInHand().equals(special2) || event.getPlayer().getItemInHand().equals(autorifle2)){
			TierTwo to = new TierTwo(event.getPlayer());
			to.interact(event);
		}
		else if(event.getPlayer().getItemInHand().equals(sniper3) || event.getPlayer().getItemInHand().equals(shotgun) || event.getPlayer().getItemInHand().equals(special3) || event.getPlayer().getItemInHand().equals(autorifle3)){
			TierThree to = new TierThree(event.getPlayer());
			to.interact(event);
		}
		else if(event.getPlayer().getItemInHand().equals(sniper4) || event.getPlayer().getItemInHand().equals(shotgun4) || event.getPlayer().getItemInHand().equals(special4) || event.getPlayer().getItemInHand().equals(autorifle4)){
			TierFour to = new TierFour(event.getPlayer());
			to.interact(event);
		}
		else if(event.getPlayer().getItemInHand().equals(cancel)){
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
}
