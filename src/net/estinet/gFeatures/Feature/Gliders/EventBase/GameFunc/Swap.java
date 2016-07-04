package net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.shampaggon.crackshot.CSUtility;

import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.Gliders.Basic;
import net.estinet.gFeatures.Feature.Gliders.Mode;
import net.estinet.gFeatures.Feature.Gliders.Team;
import net.md_5.bungee.api.ChatColor;

public class Swap {
	public void init(){
		Basic.swap = true;
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				if(!Basic.mode.equals(Mode.ENDED)){
					StartStop ss = new StartStop();
					if(Basic.firstteam.equals(Team.BLUE)){
						ss.stopGame(Team.BLUE);
					}
					else{
						ss.stopGame(Team.NONE);
					}
				}
			}
		}, 6000L);// counter just in case game keeps going
		Action.sendAllTitle(ChatColor.BOLD + "Switching teams!", "", 20, 20, 20);
		for(UUID uuid : Basic.teams.keySet()){
			Player p = Bukkit.getPlayer(uuid);
			if(Basic.teams.get(uuid).equals(Team.ORANGE)){
				Action.sendAll(ChatColor.GOLD + "You are now attacking the island!");
				ClearInventory ci = new ClearInventory();
				ci.clearInv(p);
				p.setGameMode(GameMode.ADVENTURE);
				int random = (int) Math.floor(Math.random() * Basic.planespawn.size());
				p.teleport(Basic.planespawn.get(random));
				ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)3);
				p.getInventory().setHelmet(wool);
				
				p.getInventory().setChestplate(new ItemStack(Material.ELYTRA, 1));
				
				CSUtility cs = new CSUtility();
				cs.giveWeapon(p, "Pistol", 1);
				cs.giveWeapon(p, "Grenade", 1);
			}
			else{
				Action.sendAll(ChatColor.DARK_AQUA + "You are now defending the island!");
				ClearInventory ci = new ClearInventory();
				ci.clearInv(p);
				p.setGameMode(GameMode.ADVENTURE);
				int random = (int) Math.floor(Math.random() * Basic.towerspawn.size());
				p.teleport(Basic.towerspawn.get(random));
				
				ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)1);
				p.getInventory().setHelmet(wool);
				
				CSUtility cs = new CSUtility();
				cs.giveWeapon(p, "Sniper", 1);
				cs.giveWeapon(p, "Shotgun", 1);
				cs.giveWeapon(p, "Auto-Rifle", 1);
			}
		}
	}
}
