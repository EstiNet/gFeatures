package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.Feature.gWarsSuite.Statistics;
import net.genesishub.gFeatures.Feature.gWarsSuite.gWarsMode;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interaction {
	Statistics stats = new Statistics();
	Inventory inv = new Inventory();
	TeamMenu tm = new TeamMenu();
	GunMenu gm = new GunMenu();
	public void intialize(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if(stats.getMode(p).equals(gWarsMode.MAINMENU)){
			inv.interact(event);
		}
		else if(stats.getMode(p).equals(gWarsMode.TEAMMENU)){
			tm.interact(event);
		}
		else if(stats.getMode(p).equals(gWarsMode.GUNMENU)){
			gm.interaction(event);
		}
		else if(stats.getMode(p).equals(gWarsMode.SPAWNMENU)){
			SpawnMenu sm = new SpawnMenu(p);
			sm.interact(event);
		}
	}
}
