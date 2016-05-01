package net.estinet.gFeatures.Feature.CTF.Holo;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;

public class WaitingMenu {
	public void init(Player p){
		if(p.getInventory().getItemInMainHand().getType().equals(Material.COMPASS)){
			CliotePing cp = new CliotePing();
			cp.sendMessage("redirect " + p.getName() + " MinigameHub", "Bungee");
			p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 25, 25);
		}
	}
}
