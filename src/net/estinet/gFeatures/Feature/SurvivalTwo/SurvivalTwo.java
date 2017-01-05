package net.estinet.gFeatures.Feature.SurvivalTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

public class SurvivalTwo extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	
	public static List<UUID> playerPlace = new ArrayList<>();
	
	public SurvivalTwo(String featurename, String version) {
		super(featurename, version);
	}
	@Override
	public void enable(){
		Enable.onEnable();
	}
	@Override
	public void disable(){
		Disable.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerinteractevent")){
			eh.onPlayerInteract((PlayerInteractEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent) event);
		}
	}
	@Retrieval
	@Override
	public void onPlayerJoin(){}
	@Retrieval
	@Override
	public void onPlayerInteract(){}

}
