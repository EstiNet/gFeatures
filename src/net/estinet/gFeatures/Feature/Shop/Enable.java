package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;

import com.lambdaworks.redis.*;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.sync.RedisCommands;

public class Enable{
	static ConfigHub ch = new ConfigHub();
	@SuppressWarnings("deprecation")
	public static void onEnable(){
		Bukkit.getLogger().info("[Shop] Enabled!");
		ch.setupConfig();
		
		RedisClient redisClient = RedisClient.create("redis://" + Shop.password + "@" + Shop.IP + ":" + Shop.port + "/" + Shop.databaseNum);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		syncCommands.set("key", "Hello, Redis!");

		connection.close();
		redisClient.shutdown();
		
	}
}
