package net.genesishub.gFeatures.Feature.gDestroyCritical;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class gDestroyCritical extends gFeature{

	net.genesishub.gFeatures.Feature.gDestroyCritical.Listeners listeners = new net.genesishub.gFeatures.Feature.gDestroyCritical.Listeners();
	
	public gDestroyCritical(String featurename, double d) {
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
			listeners.playerJoinEvent((PlayerJoinEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			listeners.playerLeaveEvent((PlayerQuitEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("blockbreakevent")){
			listeners.blockbreakevent((BlockBreakEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Retrieval
	public void onPlayerLeave(){}
	@Retrieval
	public void onPlayerBreakBlock(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			listeners.onCommand(sender, cmd, label, args);
	}
}
