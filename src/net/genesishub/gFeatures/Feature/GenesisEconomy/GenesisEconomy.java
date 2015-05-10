package net.genesishub.gFeatures.Feature.GenesisEconomy;

import java.io.IOException;
import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import com.earth2me.essentials.api.UserDoesNotExistException;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

public class GenesisEconomy extends gFeature{
	
	net.genesishub.gFeatures.Feature.GenesisEconomy.Listeners listeners = new net.genesishub.gFeatures.Feature.GenesisEconomy.Listeners();
	
	public GenesisEconomy(String featurename, double d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		try {
			listeners.onEnable();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			try {
				listeners.onCommand(sender, cmd, label, args);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (UserDoesNotExistException e) {
				e.printStackTrace();
			}
	}
}
