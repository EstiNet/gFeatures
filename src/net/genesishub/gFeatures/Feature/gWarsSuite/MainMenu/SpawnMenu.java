package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.OrangeTeam;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnMenu {
	Player p;
	ItemStack teamspawn, capturespawn, mainbase, innisfilhighwayexit, kloynehighwayexit, bridge;
	public SpawnMenu(Player player){
		p = player;
		
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
