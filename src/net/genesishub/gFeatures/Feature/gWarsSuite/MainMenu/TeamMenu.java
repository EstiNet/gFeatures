package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;
import net.genesishub.gFeatures.API.Messaging.ActionAPI;
import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;
import net.genesishub.gFeatures.Feature.gWarsSuite.gWarsMode;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeamMenu {
	GunMenu gm = new GunMenu();
	Statistics stats = new Statistics();
	ClearInventory ci = new ClearInventory();
	public void initialize(Player p){
		ci.clearInv(p);
		
		ItemStack item1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		ItemMeta item1meta = (ItemMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.GOLD + "Kloyne (Orange) Players: " + OrangeTeam.size());
		item1.setItemMeta(item1meta);
		
		ItemStack item2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
		ItemMeta item2meta = (ItemMeta) item2.getItemMeta();
		item2meta.setDisplayName(ChatColor.DARK_AQUA + "Innisfil (Blue) Players: " + BlueTeam.size());
		item2.setItemMeta(item2meta);
		
		ItemStack item3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		ItemMeta item3meta = (ItemMeta) item3.getItemMeta();
		item3meta.setDisplayName("Random");
		item3.setItemMeta(item3meta);
		
		p.getInventory().setItem(0, item1);
		p.getInventory().setItem(1, item2);
		p.getInventory().setItem(2, item3);
	}
	public void interact(PlayerInteractEvent event){
		Bukkit.getLogger().info("Clicked");
		ItemStack item1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
		ItemMeta item1meta = (ItemMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.GOLD + "Kloyne (Orange) Players: " + OrangeTeam.size());
		item1.setItemMeta(item1meta);
		
		ItemStack item2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		ItemMeta item2meta = (ItemMeta) item2.getItemMeta();
		item2meta.setDisplayName(ChatColor.DARK_AQUA + "Innisfil (Blue) Players: " + BlueTeam.size());
		item2.setItemMeta(item2meta);
		
		ItemStack item3 = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		ItemMeta item3meta = (ItemMeta) item3.getItemMeta();
		item3meta.setDisplayName(ChatColor.DARK_AQUA + "Random");
		item3.setItemMeta(item3meta);
		
		if((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_AIR))){
			if(event.getPlayer().getItemInHand().equals(item1)){
				if(OrangeTeam.size() > BlueTeam.size()){
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Can't join " + ChatColor.GOLD + "Kloyne" + ChatColor.GRAY + " because the teams will be unfair!");
				}
				else{
					OrangeTeam.addPlayer(event.getPlayer());
					finals(event.getPlayer());
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Joined " + ChatColor.GOLD + "Kloyne" + ChatColor.GRAY);
				}
			}
			else if(event.getPlayer().getItemInHand().equals(item2)){
				if(OrangeTeam.size() < BlueTeam.size()){
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Can't join " + ChatColor.DARK_AQUA + "Innisfil" + ChatColor.GRAY + " because the teams will be unfair!");
				}
				else{
					BlueTeam.addPlayer(event.getPlayer());
					finals(event.getPlayer());
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Joined " + ChatColor.GOLD + "Innisfil" + ChatColor.GRAY);
				}
			}
			else if(event.getPlayer().getItemInHand().equals(item3)){
				if(OrangeTeam.size() <= BlueTeam.size()){
					OrangeTeam.addPlayer(event.getPlayer());
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Joined " + ChatColor.GOLD + "Kloyne" + ChatColor.GRAY);
				}
				else{
					BlueTeam.addPlayer(event.getPlayer());
					finals(event.getPlayer());
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Joined " + ChatColor.GOLD + "Innisfil" + ChatColor.GRAY);
				}
			}
		}
	}
	public void finals(Player p){
		//ActionAPI.sendActionBar(p, ChatColor.AQUA + "Please select a kit.");
		stats.setMode(p, gWarsMode.GUNMENU);
		gm.setup(p);
	}
}
