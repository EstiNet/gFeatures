package net.estinet.gFeatures.Feature.Spleef;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.Feature.Base.Disable;
import net.estinet.gFeatures.Feature.Base.Enable;
import net.estinet.gFeatures.Feature.Base.EventHub;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionGame;

public class Spleef extends FusionGame implements Events{
	
	EventHub eh = new EventHub();
	
	public Spleef(String featurename, String version) {
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
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
	}
	@Override
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	public void enoughPlayers(){
		
	}
	@Override
	public void waitTimerComplete(){
		
	}
}
