package net.genesishub.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

public class Damage {
	Source s = new Source();
	Statistics stats = new Statistics();
	public void onEntityDamage(EntityDamageByEntityEvent event){
		if((OrangeTeam.hasPlayer((Player) event.getDamager()) &&  OrangeTeam.hasPlayer((Player) event.getEntity())) || (BlueTeam.hasPlayer((Player) event.getDamager()) &&  BlueTeam.hasPlayer((Player) event.getEntity()))){
			event.setCancelled(true);
			Bukkit.getLogger().info("Damage averted.");
		}
		else{
			Player death = (Player) event.getEntity();
			Damageable d = (Damageable) death;
			int health = (int) d.getHealth();
			double damage = event.getDamage();
			if(health - damage <= 0){
				stats.addDeaths((Player)event.getEntity(), 1);
				stats.addKill((Player)event.getDamager(), 1);
				s.flushAll();
				Bukkit.getLogger().info("Done.");
			}
		}
	}
	public void onWeaponDamage(WeaponDamageEntityEvent event){
		if((OrangeTeam.hasPlayer((Player) event.getDamager()) &&  OrangeTeam.hasPlayer((Player) event.getVictim())) || (BlueTeam.hasPlayer((Player) event.getDamager()) &&  BlueTeam.hasPlayer((Player) event.getVictim()))){
			event.setCancelled(true);
			Bukkit.getLogger().info("Damage averted.");
		}
		else{
			Player death = (Player) event.getVictim();
			Damageable d = (Damageable) death;
			int health = (int) d.getHealth();
			double damage = event.getDamage();
			if(health - damage <= 0){
				stats.addDeaths((Player)event.getVictim(), 1);
				stats.addKill((Player)event.getDamager(), 1);
				s.flushAll();
				Bukkit.getLogger().info("Done.");
			}
		}
	}
}
