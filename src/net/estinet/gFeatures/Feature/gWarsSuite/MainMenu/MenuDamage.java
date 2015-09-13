package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

public class MenuDamage {
	public void onEntityDamage(EntityDamageByEntityEvent event){
		event.setCancelled(true);
	}
	public void onWeaponDamage(WeaponDamageEntityEvent event){
		event.setCancelled(true);
	}
}
