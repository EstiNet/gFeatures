package net.estinet.gFeatures.Feature.Friendship;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.gFeature;

public class Friendship extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	
	public Friendship(String featurename, String d) {
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
		/*if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}*///maybe after we add player join msgs
	}
	//@Retrieval
	//public void onPlayerJoin(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			
	}
	
}
