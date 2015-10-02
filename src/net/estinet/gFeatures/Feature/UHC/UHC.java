package net.estinet.gFeatures.Feature.UHC;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

public class UHC extends gFeature implements Events{

	EventHub eh = new EventHub();
	CommandHub ch = new CommandHub();
	
	public UHC(String featurename, String d) {
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
		else if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			eh.logthatplayer((PlayerQuitEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Retrieval
	public void onPlayerLeave(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			ch.onCommand(sender, cmd, label, args);
	}
}
