package net.genesishub.gFeatures.Feature.gFactions;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class gFactions extends gFeature{
	Listeners listeners = new Listeners();
	public gFactions(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		listeners.onEnable();
	}
	@Override
	public void disable(){
		listeners.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			listeners.onPlayerJoin((PlayerJoinEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playercommandpreprocessevent")){
			listeners.onCommandPre((PlayerCommandPreprocessEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Retrieval
	public void onPlayerCommand(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			//When commands are implemented
	}
}
