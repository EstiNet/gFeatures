package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

public class Damage {
	Statistics stats = new Statistics();
	public void onEntityDamage(EntityDamageByEntityEvent event){
		if((OrangeTeam.hasPlayer((Player) event.getDamager()) &&  OrangeTeam.hasPlayer((Player) event.getEntity())) || (BlueTeam.hasPlayer((Player) event.getDamager()) &&  BlueTeam.hasPlayer((Player) event.getEntity()))){
			event.setCancelled(true);
			Bukkit.getLogger().info("Damage averted.");
		}
		else{
			if(event.getEntity().isDead()){
				stats.addDeaths((Player)event.getEntity());
				stats.addKill((Player)event.getDamager());
			}
		}
	}
	public void onWeaponDamage(WeaponDamageEntityEvent event){
		if((OrangeTeam.hasPlayer((Player) event.getDamager()) &&  OrangeTeam.hasPlayer((Player) event.getVictim())) || (BlueTeam.hasPlayer((Player) event.getDamager()) &&  BlueTeam.hasPlayer((Player) event.getVictim()))){
			event.setCancelled(true);
			Bukkit.getLogger().info("Damage averted.");
		}
		else{
			if(event.getVictim().isDead()){
				stats.addDeaths((Player)event.getVictim());
				stats.addKill((Player)event.getDamager());
			}
		}
	}
}
