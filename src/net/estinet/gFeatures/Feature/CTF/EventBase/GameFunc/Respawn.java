package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Team;
import net.estinet.gFeatures.Feature.CTF.Holo.SpawnMenu;

public class Respawn {
	ClearInventory ci = new ClearInventory();
	SpawnMenu sm = new SpawnMenu();
	public void respawn(Player p){
		sm.init(p);
	}
	public void fullrespawn(Player p){
		if(Basic.teams.get(p.getUniqueId()).equals(Team.ORANGE)){
			p.setGameMode(GameMode.ADVENTURE);
			p.teleport(Basic.orangespawn);
			p.setWalkSpeed((float) 0.3);
			ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)1);
			p.getInventory().setHelmet(wool);
		}
		else{
			p.setGameMode(GameMode.ADVENTURE);
			p.teleport(Basic.bluespawn);
			p.setWalkSpeed((float) 0.3);
			ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)3);
			p.getInventory().setHelmet(wool);
		}
	}
}
