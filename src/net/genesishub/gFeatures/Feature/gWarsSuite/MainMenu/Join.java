package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.Basic;
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
		//TODO PLAYER TELEPORT THINGY
		Basic.Basic.getgPlayer(event.getPlayer().getName()).setValue("gWars.Mode", "MAINMENU");
		Player p = event.getPlayer();
		p.teleport(Constants.spawnonjoin);
		for (Player players : Bukkit.getOnlinePlayers()){
            players.hidePlayer(p);
        }
		ItemStack item1 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.CREEPER.ordinal());
		SkullMeta item1meta = (SkullMeta) item1.getItemMeta();
		item1meta.setDisplayName(ChatColor.GOLD + "Singleplayer");
		p.getInventory().setItem(0, item1);;
	}
	@SuppressWarnings("deprecation")
	public void end(Player p){
		for (Player players : Bukkit.getOnlinePlayers()){
            players.showPlayer(p);
        }
	}
}
