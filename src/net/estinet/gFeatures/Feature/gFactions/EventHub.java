package net.estinet.gFeatures.Feature.gFactions;

import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.world.WorldLoadEvent;

import net.estinet.gFeatures.Feature.gFactions.Menus.GetMenu;

public class EventHub {
	GetMenu gm = new GetMenu();
	public void onPlayerInteract(PlayerInteractEntityEvent event){
		if(event.getRightClicked().getEntityId() == 426){
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
		}
	}
	public void onEntityDamage(EntityDamageEvent event){
		if(event.getEntityType().equals(EntityType.ENDER_CRYSTAL)){
			event.setCancelled(true);
		}
	}
	public void onEntityExplode(EntityExplodeEvent event){
		if(event.getEntityType().equals(EntityType.ENDER_CRYSTAL)){
			event.setCancelled(false);
		}
	}
}
