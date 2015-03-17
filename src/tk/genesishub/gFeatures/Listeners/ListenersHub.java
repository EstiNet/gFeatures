package tk.genesishub.gFeatures.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import tk.genesishub.gFeatures.GenesisAccess.Main;
import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisEconomyPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisScorePlugin;
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
	tk.genesishub.gFeatures.GenesisEconomy.Listeners gEconomy = new tk.genesishub.gFeatures.GenesisEconomy.Listeners();
	tk.genesishub.gFeatures.gDestroyCritical.Listeners gDestroy = new tk.genesishub.gFeatures.gDestroyCritical.Listeners();
	tk.genesishub.gFeatures.gScore.Listeners gScore = new tk.genesishub.gFeatures.gScore.Listeners();
	static PlayerJoinEvent playerjoin;
	static PlayerQuitEvent playerquit;
	static PlayerMoveEvent playermove;
	static PlayerDeathEvent playerdeath;
	static PlayerRespawnEvent playerrespawn;
	static EntityDamageByEntityEvent damageentity;
	static WeaponDamageEntityEvent weaponevent;
	static PlayerInteractEvent playerinteract;
	static BlockBreakEvent blockbreak;
	static AsyncPlayerChatEvent playerchat;
	static PlayerCommandPreprocessEvent playercommand;
	
	gWarsSuitePlugin gwsp = new gWarsSuitePlugin();
	
	protected void PlayerJoinInitialize(){
		inTo();
		try {
			if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
				gDestroy.playerJoinEvent(playerjoin);
			}
			if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
				gWars.onPlayerJoin(playerjoin);
			}
			if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
				GenesisAccess.PlayerJoinEvent(playerjoin);
			}
			if(GenesisEconomyPlugin.getState().equals(PluginState.ENABLE)){
				gEconomy.onPlayerJoin(playerjoin);
			}
			if(GenesisScorePlugin.getState().equals(PluginState.ENABLE)){
				gScore.onPlayerJoin(playerjoin);
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
			if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
				gWars.onPlayerQuit(playerquit);
			}
			if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
				GenesisAccess.PlayerleaveEvent(playerquit);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerMoveInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			gWars.onPlayerMove(playermove);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerRespawnInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			gWars.onPlayerRespawn(playerrespawn);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerDeathInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
				gWars.onPlayerDeath(playerdeath);
			}
			if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
				GenesisAccess.PlayerSlainEvent(playerdeath);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void EntityDamageEntityInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			gWars.onEntityDamageByEntity(damageentity);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void WeaponDamageEntityInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			gWars.onWeaponDamageEntity(weaponevent);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerInteractInitialize(){
		inTo();
		try {
			if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
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
	protected void PlayerChatInitialize(){
		inTo();
		if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
			GenesisAccess.PlayerChatEvent(playerchat);
		}
	}
	protected void PlayerCommandEvent(){
		inTo();
		if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			gWars.onCommandPre(playercommand);
		}
		if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
			GenesisAccess.PlayerCommandEvent(playercommand);
		}
	}
	private void inTo(){
		
	}
}
