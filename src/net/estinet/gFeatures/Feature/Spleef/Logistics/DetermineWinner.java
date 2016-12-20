package net.estinet.gFeatures.Feature.Spleef.Logistics;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.ParkourRace.ParkourRace;

public class DetermineWinner {
	public static Player determine(int index){
		Object[] list = (Object[]) ParkourRace.distances.keySet().toArray();
		Arrays.sort(list);
		return Bukkit.getPlayer(ParkourRace.distances.get(list[index]));
	}
}
