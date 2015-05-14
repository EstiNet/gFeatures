package net.genesishub.gFeatures.Feature.GenesisAccess;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GenesisAccess extends gFeature{
	
	net.genesishub.gFeatures.Feature.GenesisAccess.Main main = new net.genesishub.gFeatures.Feature.GenesisAccess.Main();
	
	public GenesisAccess(String featurename, String d) {
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
		else if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			main.PlayerleaveEvent((PlayerQuitEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("asyncplayerchatevent")){
			main.PlayerChatEvent((AsyncPlayerChatEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playercommandpreprocessevent")){
			main.PlayerCommandEvent((PlayerCommandPreprocessEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdeathevent")){
			main.PlayerSlainEvent((PlayerDeathEvent)event);
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Retrieval
	public void onPlayerQuit(){}
	@Retrieval
	public void onPlayerChat(){}
	@Retrieval
	public void onPlayerCommand(){}
	@Retrieval
	public void onPlayerDeath(){}
}
