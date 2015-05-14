package net.genesishub.gFeatures.Feature.GenesisBackup;

import java.io.IOException;

import net.genesishub.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;

public class GenesisBackup extends gFeature{
	
	net.genesishub.gFeatures.Feature.GenesisBackup.Listeners listeners = new net.genesishub.gFeatures.Feature.GenesisBackup.Listeners();
	
	public GenesisBackup(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		try {
			listeners.onEnable();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void disable(){
		listeners.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
	}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			listeners.onCommand(sender, cmd, label, args);
	}
}
