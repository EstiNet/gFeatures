package net.estinet.gFeatures.Feature.SurvivalTwo;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

public class SurvivalTwo extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	
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
	}
	@Retrieval
	public void onPlayerInteract(){}

}
