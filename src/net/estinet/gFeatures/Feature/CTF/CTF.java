package net.estinet.gFeatures.Feature.CTF;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

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

public class CTF extends gFeature implements Events{
	
	EventHub eh = new EventHub();
	CommandHub ch = new CommandHub();
	
	public CTF(String featurename, String d) {
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
			eh.onPlayerLeave((PlayerQuitEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("inventoryclickevent")){
			eh.onOpenInventory((InventoryClickEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("EntityDamageByEntityEvent")){
			eh.onEntityDamageByEntity((EntityDamageByEntityEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("playermoveevent")){
			eh.onPlayerMove((PlayerMoveEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdropitemevent")){
			eh.onPlayerDrop((PlayerDropItemEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerpickupitemevent")){
			eh.onPlayerPickup((PlayerPickupItemEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerinteractevent")){
			eh.onPlayerInteract((PlayerInteractEvent) event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdeathevent")){
			eh.onPlayerDeath((PlayerDeathEvent) event); 
		}
		else if(event.getEventName().equalsIgnoreCase("Weapondamageentityevent")){
			eh.onWeaponDamageEntity((WeaponDamageEntityEvent) event); 
		}
		else if(event.getEventName().equalsIgnoreCase("foodlevelchangeevent")){
			eh.onFoodLevelChange((FoodLevelChangeEvent) event);
		}
	}
	@Retrieval
	@Override
	public void onPlayerJoin(){}
	@Retrieval
	@Override
	public void onPlayerLeave(){}
	@Override
	@Retrieval
	public void onInventoryClick(){}
	@Override
	@Retrieval
	public void onEntityDamageByEntity(){}
	@Override
	@Retrieval
	public void onPlayerMove(){}
	@Override
	@Retrieval
	public void onPlayerDrop(){}
	@Override
	@Retrieval
	public void onPlayerInteract(){}
	@Override
	@Retrieval
	public void onPlayerDeath(){}
	@Override
	@Retrieval
	public void onWeaponDamageEntity(){}
	@Override
	@Retrieval
	public void onFoodLevelChange(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			ch.onCommand(sender, cmd, label, args);
	}
}

