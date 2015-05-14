package net.genesishub.gFeatures.Feature.gScore;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.earth2me.essentials.api.UserDoesNotExistException;

public class gScore extends gFeature{
	
	Listeners listeners = new Listeners();
	
	public gScore(String featurename, String d) {
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
			try {
				listeners.onPlayerJoin((PlayerJoinEvent)event);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (UserDoesNotExistException e) {
				e.printStackTrace();
			}
		}
		else if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			try {
				listeners.onPlayerLeave((PlayerQuitEvent)event);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (UserDoesNotExistException e) {
				e.printStackTrace();
			}
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Retrieval
	public void onPlayerLeave(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
		//When stuff actually happens
	}
}
