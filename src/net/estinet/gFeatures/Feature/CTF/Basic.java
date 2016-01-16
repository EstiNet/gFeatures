package net.estinet.gFeatures.Feature.CTF;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Basic {
	public static Location orangespawn;
	public static Location bluespawn;
	public static HashMap<Player, PlayerMode> modes = new HashMap<>();
	public static Mode mode = Mode.WAITING;
}
