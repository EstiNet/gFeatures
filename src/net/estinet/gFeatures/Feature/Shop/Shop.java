package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisStringsConnection;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.Feature.Shop.Enums.Trails;

public class Shop extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	
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
	}
	
	public static int getNumOfTrails(String uuid){
		
	}
	public static boolean getTrail(String uuid, String trailName){
		RedisClient client = RedisClient.create("redis://" + Shop.password + "@" + Shop.IP + ":" + Shop.port);
		RedisStringsConnection<String, String> connection = (RedisStringsConnection<String, String>) client.connect();
		String value = connection.get("trails-" + uuid + "-" + trailName);
		return Boolean.getBoolean(value);
	}
	public static int getTotalNumOfTrails(){
		return Trails.values().length;
	}
	
	@Retrieval
	public void onPlayerJoin(){}
}
