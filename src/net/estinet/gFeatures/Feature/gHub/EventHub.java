package net.estinet.gFeatures.Feature.gHub;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.gRanks.Retrieve;

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
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class EventHub {
	static ItemStack navigator, additions, settings, pane;
	HidePlayers hp = new HidePlayers();
	Stacker st = new Stacker();
	
	public EventHub(){
		navigator = createItem(Material.COMPASS, ChatColor.GOLD + "Navigator");
		additions = createItem(Material.CHEST, ChatColor.BLUE + "Shop");
		settings = createItem(Material.FURNACE, ChatColor.GRAY + "Settings");
		pane = createItem(Material.STAINED_GLASS_PANE, ChatColor.GOLD + "Esti" + ChatColor.DARK_AQUA + "Net");
		pane = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short) 7);
		ItemMeta im = pane.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Esti" + ChatColor.DARK_AQUA + "Net");
		pane.setItemMeta(im);
	}
	
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		ClearInventory ci = new ClearInventory();
		ci.clearInv(p);
		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().setItem(0, pane);
		p.getInventory().setItem(1, pane);
		p.getInventory().setItem(2, pane);
		p.getInventory().setItem(6, pane);
		p.getInventory().setItem(4, navigator);	
		p.getInventory().setItem(3, additions);
		p.getInventory().setItem(5, settings);
		p.getInventory().setItem(7, pane);
		p.getInventory().setItem(8, pane);
		Constants.playerOn.put(p.getUniqueId(), true);
		Thread thr = new Thread(new Runnable(){
		public void run(){
		try{
		Retrieve r = new Retrieve();
		String prefixs = net.estinet.gFeatures.Feature.gRanks.Basis.getRank(r.getRank(event.getPlayer())).getPrefix();
		String prefix = prefixs.replace('&', '§');
		event.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + prefix + "" + ChatColor.WHITE + p.getName());
		}
		catch(Exception e){
			event.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Join" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + p.getName());
		}
		}
		});
		thr.start();
	}
	public void onPlayerDrop(PlayerDropItemEvent event){
		event.setCancelled(true);
	}
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
		switch(event.getPlayer().getInventory().getItemInMainHand().getType()){
		case CHEST:
			event.getPlayer().sendMessage(ChatColor.GOLD + "I'm still a work in progress!");
			break;
		case FURNACE:
			Settings s = new Settings();
			s.init(event.getPlayer());
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
	      player.getLocation().getWorld().playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1.0F, -5.0F);
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
		Player p = (Player) event.getEntity();
		p.setFoodLevel(20);
		event.setCancelled(true);
	}
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
		st.onEntityInteract(event);
	}
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
		event.setCancelled(true);
	}
	public void onWeatherChange(WeatherChangeEvent event){
		boolean d = event.toWeatherState();
		if(d){
			event.setCancelled(true);
		}
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		try{
		Retrieve r = new Retrieve();
		String prefixs = net.estinet.gFeatures.Feature.gRanks.Basis.getRank(r.getRank(event.getPlayer())).getPrefix();
		String prefix = prefixs.replace('&', '§');
		event.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Leave" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + prefix + "" + ChatColor.WHITE + event.getPlayer().getName());
		}
		catch(Exception e){
			event.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.DARK_AQUA + "Leave" + ChatColor.GOLD + "]" + ChatColor.RESET + " " + ChatColor.WHITE + event.getPlayer().getName());
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

	public void onInventoryInteract(InventoryInteractEvent event) {
		event.setCancelled(true);
	}
}
