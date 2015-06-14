package net.genesishub.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventHub {
	ItemStack navigator, stacker, hider, additions, settings;
	
	public EventHub(){
		navigator = createItem(Material.COMPASS, ChatColor.GOLD + "Navigator");
		hider = createItem(Material.WATCH, ChatColor.DARK_AQUA + "Hide Players");
		stacker = createItem(Material.SULPHUR, ChatColor.AQUA + "Stacker");
		additions = createItem(Material.CHEST, ChatColor.BLUE + "Shop");
		settings = createItem(Material.FURNACE, ChatColor.GRAY + "Settings");
	}
	
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().setItem(0, navigator);
		p.getInventory().setItem(1, stacker);
		p.getInventory().setItem(2, navigator);
		p.getInventory().setItem(3, additions);
		p.getInventory().setItem(4, settings);
	}
	public void onPlayerDrop(PlayerDropItemEvent event){
		event.setCancelled(true);
	}
	public void onPlayerInteract(PlayerInteractEvent event){
		switch(event.getPlayer().getItemInHand().getType()){
		case WATCH:
			break;
		case SULPHUR:
			break;
		case CHEST:
			break;
		case FURNACE:
			break;
		default:
			break;
		}
	}
	public void onPlayerToggleFlight(PlayerToggleFlightEvent event){
		Player player = event.getPlayer();
	    if ((player.getGameMode() != GameMode.CREATIVE))
	    {
	      event.setCancelled(true);
	      player.setAllowFlight(false);
	      player.setFlying(false);
	      player.setVelocity(player.getLocation().getDirection().multiply(1.6D).setY(1.0D));
	      player.getLocation().getWorld().playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0F, -5.0F);
	    }
	}
	public void onPlayerMove(PlayerMoveEvent event){
		event.getPlayer().setAllowFlight(true);
	}
	public void onInventoryClick(InventoryClickEvent event){
		event.setCancelled(true);
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
