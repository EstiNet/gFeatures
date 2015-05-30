package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeamMenu {
	public void initialize(Player p){
		ItemStack item1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		ItemMeta item1meta = (ItemMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.GOLD + "Kloyne(Orange)");
		item1.setItemMeta(item1meta);
		
		ItemStack item2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		ItemMeta item2meta = (ItemMeta) item2.getItemMeta();
		item2meta.setDisplayName(ChatColor.DARK_AQUA + "Innisfil (Blue) Players: " + BlueTeam.size());
		item2.setItemMeta(item2meta);
		
		p.getInventory().setItem(0, item1);
		p.getInventory().setItem(1, item2);
	}
}
