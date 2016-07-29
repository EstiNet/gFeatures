package net.estinet.gFeatures.Feature.Shop;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.sync.RedisCommands;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.Feature.Shop.Enums.Trails;

public class Shop extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	
	public static RedisClient redisClient = null;
	public static StatefulRedisConnection<String, String> connection = null;
	public static RedisCommands<String, String> syncCommands = null;
	
	public static HashMap<UUID, String> playerTrail = new HashMap<>();
	
	public static String IP = "", port = "", password = "", databaseNum = "";
	
	public Shop(String featurename, String d) {
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
			eh.onPlayerLeave((PlayerQuitEvent) event);
		}
	}
	
	public static int getNumOfTrails(String uuid){
		int num = 0;
		for(Trails trail : Trails.values()){
			if(syncCommands.get("trails-" + uuid + "-" + trail.toString()).equals("true")){
				num++;
			}
		}
		return num;
	}
	public static boolean getTrail(String uuid, String trailName){
		String value = syncCommands.get("trails-" + uuid + "-" + trailName);
		return Boolean.getBoolean(value);
	}
	public static int getTotalNumOfTrails(){
		return Trails.values().length;
	}
	
	@Retrieval
	@Override
	public void onPlayerJoin(){}
	
	@Retrieval
	@Override
	public void onPlayerLeave(){}
}
