package net.genesishub.gFeatures;

import java.util.List;

import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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

public class Library {
	public void onPlayerJoin(PlayerJoinEvent event){
		check("onPlayerJoin", event);
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		check("onPlayerLeave", event);
	}
    public void onPlayerMove(PlayerMoveEvent event){
    	check("onPlayerMove", event);
    }
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	check("onPlayerRespawn", event);
    }
    public void onPlayerDeath(PlayerDeathEvent event){
    	check("onPlayerDeath", event);
    }
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    	check("onEntityDamageByEntity", event);
    }
    public void onWeaponDamageEntity(WeaponDamageEntityEvent event) {
    	check("onWeaponDamageEntity", event);
    }
    public void onPlayerInteract(PlayerInteractEvent event){
    	check("onPlayerInteract", event);
    }
    public void onPlayerBreakBlock(BlockBreakEvent event){
    	check("onPlayerBreakBlock", event);
    }
    public void onPlayerChat(AsyncPlayerChatEvent event){
    	check("onPlayerChat", event);
    }
    public void onPlayerCommand(PlayerCommandPreprocessEvent event){
    	check("onPlayerCommand", event);
    }
    public void onPlayerOpenInventory(InventoryOpenEvent event){
    	check("onPlayerOpenInventory", event);
    }
    public void check(String methodname, Event event){
    	List<gFeature> features = Basic.getFeatures();
		for(gFeature feature : features){
			try {
				if(!(feature.getClass().getDeclaredMethod(methodname).equals(null))){
					if(feature.getState().equals(FeatureState.ENABLE)){
					feature.eventTrigger(event);
					}
				}
			} catch (NoSuchMethodException e) {} 
			catch (SecurityException e) {}
		}
    }
}
