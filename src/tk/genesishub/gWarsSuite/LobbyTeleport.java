package tk.genesishub.gWarsSuite;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class LobbyTeleport {
	public void Initalize(PlayerMoveEvent event){
		Location loc = event.getPlayer().getLocation();
		int x = (int) loc.getX();
		int z = (int) loc.getZ();
		if(x == 134 && z == 291){
			
		}
	}
}
