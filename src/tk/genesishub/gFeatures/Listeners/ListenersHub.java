package tk.genesishub.gFeatures.Listeners;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import tk.genesishub.gFeatures.GenesisAccess.Main;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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
public class ListenersHub {
	tk.genesishub.gFeatures.gWarsSuite.Listeners gWars = new tk.genesishub.gFeatures.gWarsSuite.Listeners();
	Main GenesisAccess = new Main();
	tk.genesishub.gFeatures.gDestroyCritical.Listeners gDestroy = new tk.genesishub.gFeatures.gDestroyCritical.Listeners();
	PlayerJoinEvent playerjoin;
	PlayerQuitEvent playerquit;
	PlayerMoveEvent playermove;
	PlayerDeathEvent playerdeath;
	PlayerRespawnEvent playerrespawn;
	EntityDamageByEntityEvent damageentity;
	WeaponDamageEntityEvent weaponevent;
	PlayerInteractEvent playerinteract;
	BlockBreakEvent blockbreak;
	
	gWarsSuitePlugin gwsp = new gWarsSuitePlugin();
	
	protected ListenersHub(PlayerJoinEvent event){
		playerjoin = event;
	}
	protected ListenersHub(PlayerQuitEvent event){
		playerquit = event;
	}
	protected ListenersHub(PlayerMoveEvent event){
		playermove = event;
	}
	protected ListenersHub(PlayerRespawnEvent event){
		playerrespawn = event;
	}
	protected ListenersHub(PlayerDeathEvent event){
		playerdeath = event;
	}
	protected ListenersHub(EntityDamageByEntityEvent event){
		damageentity = event;
	}
	protected ListenersHub(WeaponDamageEntityEvent event){
		weaponevent = event;
	}
	protected ListenersHub(PlayerInteractEvent event){
		playerinteract = event;
	}
	protected ListenersHub(BlockBreakEvent event){
		blockbreak = event;
	}
	protected void PlayerJoinInitialize(){
		inTo();
		try {
			if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
				gDestroy.playerJoinEvent(playerjoin);
			}
			if(gWarsSuitePlugin.getState() == PluginState.ENABLE){
			gWars.onPlayerJoin(playerjoin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void PlayerQuitInitialize(){
		inTo();
		try {
			if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
				gDestroy.playerLeaveEvent(playerquit);
			}
			if(gWarsSuitePlugin.getState() == PluginState.ENABLE){
			gWars.onPlayerQuit(playerquit);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerMoveInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState() == PluginState.ENABLE){
			gWars.onPlayerMove(playermove);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerRespawnInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState() == PluginState.ENABLE){
			gWars.onPlayerRespawn(playerrespawn);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerDeathInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState() == PluginState.ENABLE){
			gWars.onPlayerDeath(playerdeath);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void EntityDamageEntityInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState() == PluginState.ENABLE){
			gWars.onEntityDamageByEntity(damageentity);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void WeaponDamageEntityInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState() == PluginState.ENABLE){
			gWars.onWeaponDamageEntity(weaponevent);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerInteractInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState() == PluginState.ENABLE){
			gWars.onPlayerInteract(playerinteract);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerBreakBlockInitialize(){
		inTo();
		if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
			gDestroy.blockbreakevent(blockbreak);
		}
	}
	private void inTo(){
		
	}
}
