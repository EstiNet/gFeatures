package net.estinet.gFeatures.Feature.CTF;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;

public class Basic {
	public static Location orangespawn;
	public static Location bluespawn;
	public static HashMap<UUID, PlayerMode> modes = new HashMap<>();
	public static Mode mode = Mode.WAITING;
}
