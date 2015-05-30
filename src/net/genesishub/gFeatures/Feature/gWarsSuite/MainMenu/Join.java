package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.API.Inventory.ClearInventory;
import net.genesishub.gFeatures.API.Messaging.ActionAPI;
import net.genesishub.gFeatures.Feature.gWarsSuite.Constants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public strictfp class Join {
	@SuppressWarnings("deprecation")
	public void start(PlayerJoinEvent event){
		//ActionAPI.sendActionBar(event.getPlayer(), ChatColor.AQUA + "Welcome to the " + ChatColor.GOLD + "gWars " + ChatColor.AQUA + "Beta! Code version: " + Basic.getFeature("gWarsSuite").getVersion());
		//TODO Player cinematic
		Basic.getgPlayer(event.getPlayer().getName()).setValue("gWars.Mode", "MAINMENU");
		Player p = event.getPlayer();
		ClearInventory ci = new ClearInventory();
		ci.clearInv(event.getPlayer());
		p.teleport(Constants.spawnonjoin);
		for (Player players : Bukkit.getOnlinePlayers()){
            players.hidePlayer(p);
        }
		
		ItemStack item1 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.CREEPER.ordinal());
		SkullMeta item1meta = (SkullMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.GOLD + "Singleplayer");
		item1.setItemMeta(item1meta);
		
		ItemStack item2 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta item2meta = (SkullMeta) item2.getItemMeta();
		item2meta.setDisplayName(ChatColor.GOLD + "Multiplayer");
		item2.setItemMeta(item2meta);
		
		p.getInventory().setItem(0, item1);
		p.getInventory().setItem(1, item2);
	}
	@SuppressWarnings("deprecation")
	public void end(Player p){
		for (Player players : Bukkit.getOnlinePlayers()){
            players.showPlayer(p);
        }
	}
}
