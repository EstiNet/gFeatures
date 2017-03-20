package net.estinet.gFeatures.Feature.Bedwars.EventBase.GameFunc;

import com.shampaggon.crackshot.CSUtility;
import net.estinet.gFeatures.API.Inventory.ClearInventory;
import net.estinet.gFeatures.Feature.Bedwars.Basic;
import net.estinet.gFeatures.Feature.Bedwars.Mode;
import net.estinet.gFeatures.Feature.Bedwars.Team;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class Swap {
	public void init(){
		Basic.swap = true;
		Basic.flagger = null;
		Basic.minutes = 5;
		Basic.seconds = 0;
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
				
				p.setHealth(20);
				
				CSUtility cs = new CSUtility();
				cs.giveWeapon(p, "Pistol", 1);
				cs.giveWeapon(p, "Grenade", 20);
				cs.giveWeapon(p, "GrenadeLauncher", 1);
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
				
				p.setHealth(20);
				
				CSUtility cs = new CSUtility();
				cs.giveWeapon(p, "Sniper", 1);
				cs.giveWeapon(p, "Shotgun", 1);
				cs.giveWeapon(p, "Auto-Rifle", 1);
			}
		}
	}
}
