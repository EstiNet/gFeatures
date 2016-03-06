package net.estinet.gFeatures.Feature.gFactions;

import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.world.WorldLoadEvent;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class gFactions extends gFeature{
	Listeners listeners = new Listeners();
	Enable en = new Enable();
	EventHub eh = new EventHub();
	public gFactions(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		en.plzenable();
	}
	@Override
	public void disable(){
		listeners.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			
		}
		else if(event.getEventName().equalsIgnoreCase("playerentityinteractevent")){
			eh.onPlayerInteract((PlayerInteractEntityEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("worldloadevent")){
			eh.onWorldLoad((WorldLoadEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("EntityDamageEvent")){
			eh.onEntityDamage((EntityDamageEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("EntityDamageByEntityEvent")){
			eh.onEntityDamage((EntityDamageByEntityEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("entityexplodeevent")){
			eh.onEntityExplode((EntityExplodeEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("asyncplayerchatevent")){
			eh.onPlayerChat((AsyncPlayerChatEvent)event);
		}
	}
	@Retrieval
	@Override
	public void onPlayerJoin(){}
	@Retrieval
	@Override
	public void onPlayerInteractEntity(){}
	@Retrieval
	@Override
	public void onWorldLoad(){}
	@Retrieval
	@Override
	public void onEntityDamage(){}
	@Retrieval
	@Override
	public void onEntityExplode(){}
	@Retrieval
	@Override
	public void onEntityDamageByEntity(){}
	@Retrieval
	@Override
	public void onPlayerChat(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			//When commands are implemented
	}
}
