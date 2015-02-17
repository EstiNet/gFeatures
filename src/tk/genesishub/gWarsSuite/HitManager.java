package tk.genesishub.gWarsSuite;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

public class HitManager {
	File f = new File("KillsDeaths.xml");
	StatsRetrieve sr = new StatsRetrieve();
	StatsManager sm = new StatsManager();
	Constants cons = new Constants();
	public void EntityDamageByOther(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player damaged = (Player)event.getEntity();
            Player damager = (Player)event.getDamager();

            if(Constants.bt.contains(damaged.getName()) && Constants.bt.contains(damager.getName())) { // check if both damaged and damager are on blue team
                event.setCancelled(true); // cancel the event, so no damage will be dealt.
            }

            if(Constants.ot.contains(damaged.getName()) && Constants.ot.contains(damager.getName())) { // same for red team
                event.setCancelled(true);
            }}
	}
	public void WeaponDamage(WeaponDamageEntityEvent event){
		if(true) {
            Player damaged = (Player)event.getVictim();
            Player damager = (Player)event.getPlayer();
            try{
    			Player death = (Player) event.getVictim();
    			Damageable d = (Damageable) death;
    			int health = (int) d.getHealth();
    			double damage = event.getDamage();
    			if(health - damage <= 0){
    			death.getInventory().remove(Material.CHEST);
    			death.getInventory().remove(Material.STAINED_GLASS);
    			Player death1 = (Player) event.getVictim();
    			Player cause1 = event.getPlayer();
    			sm.giveKills(cause1, 1);
    			sm.giveDeaths(death1, 1);
    			}
            if(Constants.bt.contains(damaged.getName()) && Constants.bt.contains(damager.getName())) { // check if both damaged and damager are on blue team
                event.setCancelled(true); // cancel the event, so no damage will be dealt.
            }
            if(Constants.ot.contains(damaged.getName()) && Constants.ot.contains(damager.getName())) { // same for red team
                event.setCancelled(true);
            }
			}catch(Exception e){
				e.printStackTrace();
			}
        }
	}
}
