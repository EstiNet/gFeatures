package net.genesishub.gFeatures.Feature.gWarsSuite.MainMenu;

import net.genesishub.gFeatures.Feature.gWarsSuite.Constants;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join {
	public void start(PlayerJoinEvent event){
		//TODO PLAYER TELEPORT THINGY
		Player p = event.getPlayer();
		p.teleport(Constants.spawnonjoin);
		for (Player players : Bukkit.getOnlinePlayers())
        {
            players.hidePlayer(p);
        }
		p.set
	}
}
