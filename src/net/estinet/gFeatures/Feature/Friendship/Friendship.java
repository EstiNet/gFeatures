package net.estinet.gFeatures.Feature.Friendship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsMenu;

public class Friendship extends gFeature implements Events{
	
	public static List<String> cacheNames = new ArrayList<>();
	
	public static HashMap<String, String> statusRequest = new HashMap<>();
	
	public static HashMap<String, List<String>> friendreq = new HashMap<>();
	
	public static HashMap<String, HashMap<String, String>> friendget = new HashMap<>();
	
	EventHub eh = new EventHub();
	
	public Friendship(String featurename, String d) {
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
		/*if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}*///maybe after we add player join msgs
	}
	//@Retrieval
	//public void onPlayerJoin(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			FriendsMenu fm = new FriendsMenu();
			fm.init((Player) sender);
	}
	
}
