package net.estinet.gFeatures.Feature.gHub.crystal;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;

public class CrystalInteract {
	public void init(Location location, Player player){
		CliotePing cp = new CliotePing();
		cp.sendMessage("mgget", "Bungee");
	}
}
