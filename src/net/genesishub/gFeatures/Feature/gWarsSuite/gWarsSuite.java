package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;

public class gWarsSuite extends gFeature{
	public gWarsSuite(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		
	}
	@Override
	public void disable(){
		
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			//ch.onCommand(sender, cmd, label, args);
	}
}
