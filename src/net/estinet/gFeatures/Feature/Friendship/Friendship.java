package net.estinet.gFeatures.Feature.Friendship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsMenu;

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
		if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			eh.onPlayerLeave((PlayerQuitEvent)event);
		}
	}
	@Retrieval
	@Override
	public void onPlayerLeave(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			FriendsMenu fm = new FriendsMenu();
			fm.init((Player) sender);
	}
	
}
