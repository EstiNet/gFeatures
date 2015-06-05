package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.API.Inventory.ClearInventory;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnMenu {
	Player p;
	ClearInventory ci = new ClearInventory();
	ItemStack teamspawn, capturespawn, mainbase, innisfilhighwayexit, kloynehighwayexit, bridge, cancel;
	public SpawnMenu(Player player){
		p = player;
		
		cancel = createItem(Material.BARRIER, ChatColor.RED + "Back");
		
		teamspawn = createItem(Material.BEACON, ChatColor.WHITE + "Posessive Spawns");
		capturespawn = createItem(Material.BEACON, ChatColor.WHITE + "Captured Spawns");
		
		kloynehighwayexit = createItem(Material.STAINED_GLASS_PANE, ChatColor.GOLD + "Kloyne Highway Exit");
		innisfilhighwayexit = createItem(Material.STAINED_GLASS_PANE, ChatColor.AQUA + "Innisfil Highway Exit");
		bridge = createItem(Material.STAINED_GLASS_PANE, ChatColor.WHITE + "Bridge");
		
		if(OrangeTeam.hasPlayer(p)){
			mainbase = createItem(Material.STAINED_GLASS_PANE, ChatColor.GOLD + "Kloyne Military Base");
		}
		else{
			mainbase = createItem(Material.STAINED_GLASS_PANE, ChatColor.AQUA + "Innisfil Military Base");
		}
	}
	public void intialize(){
		ci.clearInv(p);
		
		p.getInventory().setItem(0, teamspawn);
		p.getInventory().setItem(1, capturespawn);
	}
	public void interact(PlayerInteractEvent event){
		Player p = event.getPlayer();
		
		if(p.getItemInHand().equals(teamspawn)){
			teamMenu();
		}
		else if(p.getItemInHand().equals(capturespawn)){
			captureMenu();
		}
		else if(p.getItemInHand().equals(cancel)){
			intialize();
		}
		else{
			if(p.getItemInHand().equals(mainbase)){
				
			}
		}
	}
	private void teamMenu(){
		ci.clearInv(p);
		
		p.getInventory().setItem(0, mainbase);
		p.getInventory().setItem(8, cancel);
	}
	private void captureMenu(){
		ci.clearInv(p);
		
		p.getInventory().setItem(0, bridge);
		p.getInventory().setItem(1, innisfilhighwayexit);
		p.getInventory().setItem(2, kloynehighwayexit);
		p.getInventory().setItem(8, cancel);
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
