package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;

import com.lambdaworks.redis.*;

public class Enable{
	static ConfigHub ch = new ConfigHub();
	public static void onEnable(){
		Bukkit.getLogger().info("[Shop] Enabled!");
		ch.setupConfig();
		
		System.out.println("[Shop] Connecting to Redis...");
		
		Shop.redisClient = RedisClient.create("redis://" + Shop.password + "@" + Shop.IP + ":" + Shop.port + "/" + Shop.databaseNum);
		Shop.connection = Shop.redisClient.connect();
		Shop.syncCommands = Shop.connection.sync();

		System.out.println("[Shop] Connected!");
	}
}
