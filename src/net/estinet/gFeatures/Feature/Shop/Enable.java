package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;

import com.lambdaworks.redis.*;

public class Enable{
	static ConfigHub ch = new ConfigHub();
	public static void onEnable(){
		Bukkit.getLogger().info("[Shop] Enabled!");
		ch.setupConfig();
		
		System.out.println("[Shop] Connecting to Redis...");
		
		RedisURI ruri = new RedisURI();
		ruri.setDatabase(Integer.parseInt(Shop.databaseNum));
		ruri.setPort(Integer.parseInt(Shop.port));
		ruri.setPassword(Shop.password);
		ruri.setHost(Shop.IP);
		
		Shop.redisClient = RedisClient.create(ruri);
		Shop.connection = Shop.redisClient.connect();
		Shop.syncCommands = Shop.connection.sync();

		System.out.println("[Shop] Connected!");
	}
}
