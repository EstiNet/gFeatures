package net.estinet.gFeatures.Feature.EstiChat;

import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

public class EstiChat extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	public static String lastSent = "";
	
	public EstiChat(String featurename, String d) {
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
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("asyncplayerchatevent")){
			eh.onPlayerChat((AsyncPlayerChatEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdeathevent")){
			eh.onPlayerDeath((PlayerDeathEvent)event);
		}
	}
	@Retrieval
	@Override
	public void onPlayerChat(){}
	@Retrieval
	@Override
	public void onPlayerDeath(){}
}
