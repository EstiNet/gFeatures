package net.estinet.gFeatures.Feature.Friendship;

import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsMenu;
import net.estinet.gFeatures.gFeature;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class Friendship extends gFeature {
	
	public static List<String> cacheNames = new ArrayList<>();
	
	public static HashMap<String, String> statusRequest = new HashMap<>();
	
	public static HashMap<String, List<String>> friendreq = new HashMap<>();
	
	public static HashMap<String, HashMap<String, String>> friendget = new HashMap<>();

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
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event){
		Friendship.cacheNames.remove(event.getPlayer().getName());
	}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			FriendsMenu fm = new FriendsMenu();
			fm.init((Player) sender);
	}
	
}
