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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeamMenu {
	Statistics stats = new Statistics();
	ClearInventory ci = new ClearInventory();
	ActionAPI aapi = new ActionAPI();
	
	ItemStack item1, item2;
	
	public TeamMenu(){
		item1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		ItemMeta item1meta = (ItemMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.GOLD + "Kloyne (Orange) Players: " + OrangeTeam.size());
		item1.setItemMeta(item1meta);
		
		item2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
		ItemMeta item2meta = (ItemMeta) item2.getItemMeta();
		item2meta.setDisplayName(ChatColor.DARK_AQUA + "Innisfil (Blue) Players: " + BlueTeam.size());
		item2.setItemMeta(item2meta);
	}
	
	public void initialize(Player p){
		ci.clearInv(p);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		p.getInventory().setItem(0, item1);
        		p.getInventory().setItem(1, item2);
        	}
        }, 2L);
		
	}
	public void interact(PlayerInteractEvent event){
			if(event.getPlayer().getItemInHand().getType().equals(Material.STAINED_GLASS_PANE) && event.getPlayer().getItemInHand().getData().getData() == 1){
				if(!(BlueTeam.size() < OrangeTeam.size())){
					OrangeTeam.addPlayer(event.getPlayer());
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Joined " + ChatColor.GOLD + "Kloyne" + ChatColor.GRAY + ".");
					ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)1);
					event.getPlayer().getInventory().setHelmet(wool);
					finals(event.getPlayer());
				}else{
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Can't join " + ChatColor.GOLD + "Kloyne" + ChatColor.GRAY + " because the teams will be unfair!");
				}
			}
			else if(event.getPlayer().getItemInHand().getType().equals(Material.STAINED_GLASS_PANE) && event.getPlayer().getItemInHand().getData().getData() == 3){
				if(!(BlueTeam.size() > OrangeTeam.size())){
					BlueTeam.addPlayer(event.getPlayer());
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Joined " + ChatColor.DARK_AQUA + "Innisfil" + ChatColor.GRAY + ".");
					ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)3);
					event.getPlayer().getInventory().setHelmet(wool);
					finals(event.getPlayer());
				}
				else{
					event.getPlayer().sendMessage(ChatColor.GRAY + "[Team] Can't join " + ChatColor.GOLD + "Innisfil" + ChatColor.GRAY + " because the teams will be unfair!");
				}
			}
	}
	public void finals(Player p){
		aapi.sendActionbar(p, ChatColor.AQUA + "Please select a place to spawn.");
		stats.setMode(p, gWarsMode.SPAWNMENU);
		SpawnMenu gm = new SpawnMenu(p);
		gm.intialize();
	}
}
