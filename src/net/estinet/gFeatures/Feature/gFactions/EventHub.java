package net.estinet.gFeatures.Feature.gFactions;

import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.world.WorldLoadEvent;

import net.estinet.gFeatures.Feature.gFactions.Menus.GetMenu;

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
	GetMenu gm = new GetMenu();
	public void onPlayerInteract(PlayerInteractEntityEvent event){
		if(event.getRightClicked().getType().equals(EntityType.ENDER_CRYSTAL)){
			event.setCancelled(true);
			gm.start(event);
		}
	}
	public void onWorldLoad(WorldLoadEvent event){
		if(event.getWorld().getName().equals("Factions1.8.3")){
			for(Entity ent : event.getWorld().getEntities()){
				if(ent.getType().equals(EntityType.ENDER_CRYSTAL)){
					ent.remove();
				}
			}
		Blaze.world.spawn(Blaze.sniper, EnderCrystal.class);
		Blaze.world.spawn(Blaze.shotgun, EnderCrystal.class);
		Blaze.world.spawn(Blaze.autorifle, EnderCrystal.class);
		for(Entity ent : event.getWorld().getEntities()){
			if(ent.getType().equals(EntityType.ENDER_CRYSTAL)){
				if(ent.getLocation().equals(Blaze.sniper)){
					Blaze.snipers = ent.getUniqueId();
				}
				else if(ent.getLocation().equals(Blaze.shotgun)){
					Blaze.shotguns = ent.getUniqueId();
				}
				else if(ent.getLocation().equals(Blaze.autorifle)){
					Blaze.autorifles = ent.getUniqueId();
				}
			}
		}
		}
	}
	public void onEntityDamage(EntityDamageEvent event){
		if(event.getEntityType().equals(EntityType.ENDER_CRYSTAL)){
			event.setCancelled(true);
			try{
				EntityDamageByEntityEvent ev = (EntityDamageByEntityEvent) event;
				if(ev.getDamager() instanceof Player){
					gm.start(ev);
				}
			}	
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void onEntityExplode(EntityExplodeEvent event){
		if(event.getEntityType().equals(EntityType.ENDER_CRYSTAL)){
			event.setCancelled(false);
		}
	}
	public void onPlayerChat(AsyncPlayerChatEvent event){
		/*Player pl = event.getPlayer();
		try{
		String prefix = "";
			if((Basic.getgPlayer(pl.getUniqueId().toString()).getValue("gFactionsTier").equals("autorifle")) && !event.getPlayer().getDisplayName().contains(ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Auto-Rifler" + ChatColor.RESET + "" + ChatColor.BOLD + "]")){
				prefix = ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "Auto-Rifler" + ChatColor.RESET + "" + ChatColor.BOLD + "]";
			}
			else if((Basic.getgPlayer(pl.getUniqueId().toString()).getValue("gFactionsTier").equals("shotgun")) && !event.getPlayer().getDisplayName().contains(ChatColor.BOLD + "[" + ChatColor.GRAY + "Shotgunner" + ChatColor.RESET + "" + ChatColor.BOLD + "]")){
				prefix = ChatColor.BOLD + "[" + ChatColor.GRAY + "Shotgunner" + ChatColor.RESET + "" + ChatColor.BOLD + "]";
			}
			else if((Basic.getgPlayer(pl.getUniqueId().toString()).getValue("gFactionsTier").equals("sniper"))&& !event.getPlayer().getDisplayName().contains(ChatColor.BOLD + "[" + ChatColor.RED + "Sniper" + ChatColor.RESET + "" + ChatColor.BOLD + "]")){
				prefix = ChatColor.BOLD + "[" + ChatColor.RED + "Sniper" + ChatColor.RESET + "" + ChatColor.BOLD + "]";
			}
			else if(!event.getPlayer().getDisplayName().contains(ChatColor.BOLD + "[" + ChatColor.GOLD + "Melee" + ChatColor.RESET + "" + ChatColor.BOLD + "]")){
				prefix = ChatColor.BOLD + "[" + ChatColor.GOLD + "Melee" + ChatColor.RESET + "" + ChatColor.BOLD + "]";
			}
		event.getPlayer().setDisplayName(prefix + event.getPlayer().getDisplayName());
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
	}
}
