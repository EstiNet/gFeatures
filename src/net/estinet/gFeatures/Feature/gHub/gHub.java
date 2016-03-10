package net.estinet.gFeatures.Feature.gHub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

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

public class gHub extends gFeature implements Events{
	Listeners listeners = new Listeners();
	EventHub eh = new EventHub();
	public gHub(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		Enable e = new Enable();
		e.onEnable();
	}
	@Override
	public void disable(){
		Disable d = new Disable();
		d.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdropitemevent")){
			eh.onPlayerDrop((PlayerDropItemEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerinteractevent")){
			eh.onPlayerInteract((PlayerInteractEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("inventoryclickevent")){
			eh.onInventoryClick((InventoryClickEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playertoggleflightevent")){
			eh.onPlayerToggleFlight((PlayerToggleFlightEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playermoveevent")){
			eh.onPlayerMove((PlayerMoveEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdropitemevent")){
			eh.onPlayerDrop((PlayerDropItemEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerinteractentityevent")){
			eh.onPlayerInteractEntity((PlayerInteractEntityEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("entitydamagebyentityevent")){
			eh.onEntityDamageByEntity((EntityDamageByEntityEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			eh.onPlayerLeave((PlayerQuitEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("foodlevelchangeevent")){
			eh.onFoodLevelChange((FoodLevelChangeEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("entitydamageevent")){
			eh.onEntityDamage((EntityDamageEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("weatherchangeevent")){
			eh.onWeatherChange((WeatherChangeEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("inventoryinteractevent")){
			eh.onInventoryInteract((InventoryInteractEvent) event);
		}
	}
	@Override
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	@Retrieval
	public void onPlayerDrop(){}
	@Override
	@Retrieval
	public void onPlayerInteract(){}
	@Override
	@Retrieval
	public void onInventoryClick(){}
	@Override
	@Retrieval
	public void onPlayerToggleFlight(){}
	@Override
	@Retrieval
	public void onPlayerMove(){}
	@Override
	@Retrieval
	public void onFoodLevelChange(){}
	@Override
	@Retrieval
	public void onPlayerInteractEntity(){}
	@Override
	@Retrieval
	public void onEntityDamageByEntity(){}
	@Override
	@Retrieval
	public void onPlayerLeave(){}
	@Override
	@Retrieval
	public void onEntityDamage(){}
	@Override
	@Retrieval
	public void onWeatherChange(){}
	@Override
	@Retrieval
	public void onInventoryInteract(){}
}
