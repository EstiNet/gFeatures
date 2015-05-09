package net.genesishub.gFeatures.Feature.GenesisAccess;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

public class GenesisAccess extends gFeature{
	
	net.genesishub.gFeatures.Feature.GenesisAccess.Main main = new net.genesishub.gFeatures.Feature.GenesisAccess.Main();
	
	public GenesisAccess(String featurename, double d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		main.onEnable();
	}
	@Override
	public void disable(){
		main.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			main.PlayerJoinEvent((PlayerJoinEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Retrieval
	public void onPlayerQuit(){}
	@Retrieval
	public void onPlayerChat(){}
	
}
