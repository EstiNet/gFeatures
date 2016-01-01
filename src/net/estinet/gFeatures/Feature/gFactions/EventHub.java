package net.estinet.gFeatures.Feature.gFactions;

import org.bukkit.Bukkit;
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
import net.estinet.gFeatures.Feature.gRanks.Basis;

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
		try{
		String prefix;
		if()
		String name = prefix.replace('&', '§');
		event.getPlayer().setDisplayName(name + event.getPlayer().getName());
		}
		catch(Exception e){
			Basis.getRank("Default").addPerson(event.getPlayer().getUniqueId().toString());
		}
	}
}
