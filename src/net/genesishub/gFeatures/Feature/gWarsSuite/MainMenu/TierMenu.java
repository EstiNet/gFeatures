package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.API.Inventory.InventoryGUI;
import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;
import net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu.Tiers.*;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TierMenu {
	Statistics s = new Statistics();
	public TierMenu(Player p){
		
		ItemStack tierzero = createItem(Material.IRON_BLOCK, ChatColor.AQUA + "Tier 0", ChatColor.GOLD + "Weapons in this tier costs 0 kills.");
		ItemStack tierone = createItem(Material.GOLD_BLOCK, ChatColor.AQUA + "Tier 1", ChatColor.GOLD + "Weapons in this tier costs 5 kills.");
		ItemStack tiertwo = createItem(Material.LAPIS_BLOCK, ChatColor.AQUA + "Tier 2", ChatColor.GOLD + "Weapons in this tier costs 10 kills.");
		ItemStack tierthree = createItem(Material.DIAMOND_BLOCK, ChatColor.AQUA + "Tier 3", ChatColor.GOLD + "Weapons in this tier costs 25 kills.");
		ItemStack tierfour = createItem(Material.EMERALD_BLOCK, ChatColor.AQUA + "Tier 4", ChatColor.GOLD + "Weapons in this tier costs 50 kills.");
		ItemStack kills = createItem(Material.EMERALD, ChatColor.GREEN + "You have " + s.getKills(p) + " kills.", ChatColor.GOLD + " Play more to unlock more!");
		
		new InventoryGUI(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), "&9Cool&cInventory", 1)                                             
		.setItem(0, tierzero, new TierZero())
	    .setItem(1, tierone, new TierOne())
	    .setItem(2, new ItemStack(Material.LAPIS_BLOCK, 1), ChatColor.AQUA+"Tier 2", ChatColor.GOLD+"Weapons here cost 10 kills.")
	    .setItem(3, new ItemStack(Material.DIAMOND_BLOCK, 1), ChatColor.AQUA+"Tier 3", ChatColor.GOLD+"Weapons here cost 25 kills.")
	    .setItem(4, new ItemStack(Material.EMERALD_BLOCK, 1), ChatColor.AQUA+"Tier 4", ChatColor.GOLD+"Weapons here cost 50 kills.")
		.setItem(8, new ItemStack(Material.EMERALD, 1), ChatColor.GREEN+"You have " + s.getKills(p) + " kills.");    //^
        .setOpenAction(new OpenAction())                                        
        .openInventory(Bukkit.getPlayer("nverdier");  
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
}
