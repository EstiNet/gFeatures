package net.estinet.gFeatures.Feature.ServerQuery;

import java.util.HashMap;

import org.bukkit.event.Event;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.gFeature;

public class ServerQuery extends gFeature implements Events{
	
	private static int playerCount = 0;
	
	public static HashMap<String, Execute> hash = new HashMap<>();
	
	public ServerQuery(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		Enable.onEnable();
	}
	@Override
	public void disable(){
		Disable.onDisable();
	}
	
	public static void setPlayerCount(int amount){
		playerCount = amount;
	}
	
	public static int getPlayerCount(){
		return playerCount;
	}
	
	@Override
	public void eventTrigger(Event event) {}
}
