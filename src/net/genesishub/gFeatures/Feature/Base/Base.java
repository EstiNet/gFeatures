package net.genesishub.gFeatures.Feature.Base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import net.genesishub.gFeatures.FeatureState;
import net.genesishub.gFeatures.gFeature;

public class Base extends gFeature{
	
	EventHub eh = new EventHub();
	CommandHub ch = new CommandHub();
	
	public Base(String featurename, double d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		if(this.getState().equals(FeatureState.ENABLE)){
			Enable.onEnable();
		}
	}
	@Override
	public void disable(){
		if(this.getState().equals(FeatureState.ENABLE)){
			Disable.onDisable();
		}
	}
	@Override
	public void eventTrigger(Event event) {
		if(this.getState().equals(FeatureState.ENABLE) && event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
	}
	public void onPlayerJoin(PlayerJoinEvent event){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
		if(this.getState().equals(FeatureState.ENABLE)){
			ch.onCommand(sender, cmd, label, args);
		}
	}
}
