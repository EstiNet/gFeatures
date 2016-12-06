package net.estinet.gFeatures.Feature.FusionPlay;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionGame;

public class FusionPlay extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	
	public static List<FusionGame> games = new ArrayList<>();
	public static FusionGame currentGame = null;
	
	public FusionPlay(String featurename, String version) {
		super(featurename, version);
	}
	@Override
	public void enable(){
		Enable.onEnable();
	}
	@Override
	public void disable() {
		Disable.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}

}
