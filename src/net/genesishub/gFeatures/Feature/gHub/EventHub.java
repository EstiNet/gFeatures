package net.genesishub.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;

import net.genesishub.gFeatures.Feature.gRanks.Retrieve;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventHub {
	ItemStack navigator, stacker, hider, additions, settings;
	HidePlayers hp = new HidePlayers();
	Stacker st = new Stacker();
	
	public EventHub(){
		navigator = createItem(Material.COMPASS, ChatColor.GOLD + "Navigator");
		hider = createItem(Material.WATCH, ChatColor.DARK_AQUA + "Stacker");
		stacker = createItem(Material.SULPHUR, ChatColor.AQUA + "Hide Players");
		additions = createItem(Material.CHEST, ChatColor.BLUE + "Shop");
		settings = createItem(Material.FURNACE, ChatColor.GRAY + "Settings");
	}
	
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().setItem(0, navigator);
		p.getInventory().setItem(1, stacker);
		p.getInventory().setItem(2, hider);
		p.getInventory().setItem(3, additions);
		p.getInventory().setItem(4, settings);
		try{
		Retrieve r = new Retrieve();
		String prefixs = net.genesishub.gFeatures.Feature.gRanks.Basis.getRank(r.getRank(event.getPlayer())).getPrefix();
		String prefix = prefixs.replace('&', '§');
		event.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + prefix + "" + ChatColor.WHITE + p.getName());
		}
		catch(Exception e){
			event.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + "" + ChatColor.WHITE + p.getName());
		}
	}
	public void onPlayerDrop(PlayerDropItemEvent event){
		event.setCancelled(true);
	}
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
		switch(event.getPlayer().getItemInHand().getType()){
		case WATCH:
			st.event(event.getPlayer());
			break;
		case SULPHUR:
			hp.show(event.getPlayer());
			break;
		case REDSTONE:
			hp.hide(event.getPlayer());
			break;
		case CHEST:
			break;
		case FURNACE:
			break;
		default:
			break;
		}
		}
		st.onInteract(event);
		event.setCancelled(true);
	}
	public void onPlayerToggleFlight(PlayerToggleFlightEvent event){
		Player player = event.getPlayer();
	    if ((player.getGameMode() != GameMode.CREATIVE))
	    {
	      event.setCancelled(true);
	      player.setAllowFlight(false);
	      player.setFlying(false);
	      player.setVelocity(st.giveVector(player.getLocation()).multiply(3));
	      player.getLocation().getWorld().playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0F, -5.0F);
	    }
	}
	public void onPlayerMove(PlayerMoveEvent event){
		event.getPlayer().setAllowFlight(true);
	}
	public void onInventoryClick(InventoryClickEvent event){
		event.setCancelled(true);
	}
	public void onEntityDamage(EntityDamageEvent event){
		event.setCancelled(true);
	}
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
		st.onEntityInteract(event);
	}
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
		event.setCancelled(true);
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		try{
		Retrieve r = new Retrieve();
		String prefixs = net.genesishub.gFeatures.Feature.gRanks.Basis.getRank(r.getRank(event.getPlayer())).getPrefix();
		String prefix = prefixs.replace('&', '§');
		event.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + prefix + "" + ChatColor.WHITE + event.getPlayer().getName());
		}
		catch(Exception e){
			event.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + "" + ChatColor.WHITE + event.getPlayer().getName());
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
