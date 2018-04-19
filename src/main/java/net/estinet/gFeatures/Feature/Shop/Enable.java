package net.estinet.gFeatures.Feature.Shop;

import org.bukkit.Bukkit;

import com.lambdaworks.redis.*;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

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
		TrailLoop tl = new TrailLoop();
		tl.init();
	}
}
