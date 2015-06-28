package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.genesishub.gFeatures.Feature.gWarsSuite.Constants;
import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;
import net.genesishub.gFeatures.Feature.gWarsSuite.gWarsMode;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.BlueTeam;
import net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer.Source;
import net.md_5.bungee.api.ChatColor;

public class Finish {
	Statistics stats = new Statistics();
	Join join = new Join();
	public void intialize(Player p){
		stats.setMode(p, gWarsMode.TEAM);
		join.end(p);
		p.teleport(new Location(Bukkit.getServer().getWorld("gWars"), Constants.spawndump.get(p.getName()).getX(), Constants.spawndump.get(p.getName()).getY(), Constants.spawndump.get(p.getName()).getZ()));
		Constants.spawndump.remove(p);
		Source s = new Source();
		s.flushAll();
		ItemStack compass = createItem(Material.COMPASS, ChatColor.AQUA + "Compass");
		p.getInventory().setItem(7, compass);
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "speed walking 5 "+ p.getName());
		if(BlueTeam.hasPlayer(p)){
			ItemStack wool = new ItemStack(Material.STAINED_GLASS, 3, (byte)1);
			p.getInventory().setHelmet(wool);
		}
		else{
			ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)1);
			p.getInventory().setHelmet(wool);
		}
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
