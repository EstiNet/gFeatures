package tk.genesishub.gWarsSuite;

import java.io.File;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathManager {
	File f = new File("KillsDeaths.xml");
	StatsRetrieve sr = new StatsRetrieve();
	Constants cons = new Constants();
	Administration admin = new Administration();
	StatsManager sm = new StatsManager();
	public void ManageDeath(final Player p, PlayerDeathEvent event){
		p.getInventory().remove(Material.CHEST);
		p.getInventory().getHelmet().setType(Material.AIR);
		Constants.arena.remove(p.getName());
		Constants.gunin.remove(p.getName());
		try{
		if(event.getEntity() instanceof Player && event.getEntity().getKiller() instanceof Player){
		Player death = event.getEntity();
		Player cause = death.getKiller();
		sm.giveKills(cause, 1);
		sm.giveDeaths(death, 1);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
