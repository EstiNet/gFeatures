package net.genesishub.gFeatures.Feature.Grasslands;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

public class Grasslands extends gFeature{
	EventHub eh = new EventHub();
	CommandHub ch = new CommandHub();
	Enable enable = new Enable();
	
	public Grasslands(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		enable.onEnable();
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
	@Retrieval
	@Override
	public void onPlayerLeave(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			ch.onCommand(sender, cmd, label, args);
	}
}
