package net.genesishub.gFeatures.Feature.Statistics;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

public class Statistics extends gFeature{
	
	EventHub eh = new EventHub();
	
	public Statistics(String featurename, String d) {
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
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			//TODO Meh...
	}
}
