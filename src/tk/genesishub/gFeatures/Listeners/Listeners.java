package tk.genesishub.gFeatures.Listeners;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
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
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tk.genesishub.gFeatures.PluginManage.CameraStudioPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisBackupPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisEconomyPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisScorePlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;
import tk.genesishub.gFeatures.Skript.Skripts;
import tk.genesishub.gFeatures.Skript.Java.SkriptManager;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

/*

gFeatures main class file
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

public class Listeners extends JavaPlugin implements Listener{
	SkriptManager sm = new SkriptManager();
	String EnteredKey = "Hi!";
	String ProductKey = "gFE-69a-123-abc";
	
	ListenersHub lh = new ListenersHub();
	
	@Override
    public void onEnable() { //What to do on server load/reload
		
		/*
		 * When Enabling, you must have on your server,
		 * Worldguard
		 * Worldguard Events
		 * Crackshot
		 * */
		getLogger().info("~--------------------------------------------------------------------------------~");
        getLogger().info("[gFeatures] Starting gFeatures...");
        Enabler e = new Enabler();
        try {
			e.Enable();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
        
        if (Bukkit.getPluginManager().getPlugin("Skript") != null) {
        	// put all code related to Skript here!
        	getLogger().info("[gFeatures] Skript is detected on the server! Skript Add-Ons will function!");
        }
        
        //Product Key System
        if (EnteredKey.equals(ProductKey)){
        	//To-Do
        	getLogger().info("[gFeatures] Product Key Verified!");	
        }
        
        getLogger().info("[gFeatures] gFeatures has started.");
        getLogger().info("~--------------------------------------------------------------------------------~");
        }
 
    @Override
    public void onDisable() { //What to do on server unload/reload
       getLogger().info("[gFeatures] gFeatures is turning off...!");  
       try {
		Initialize();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
    	ListenersHub.playerjoin = event;
    	lh.PlayerJoinInitialize();
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
    	ListenersHub.playerquit = event;
    	lh.PlayerQuitInitialize();
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
    	ListenersHub.playermove = event;
    	lh.PlayerMoveInitialize();
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	ListenersHub.playerrespawn = event;
    	lh.PlayerRespawnInitialize();
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
    	ListenersHub.playerdeath = event;
    	lh.PlayerDeathInitialize();
    }
    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
    	ListenersHub.damageentity = event;
    	lh.EntityDamageEntityInitialize();
    }
    @EventHandler
    public void onHit1(WeaponDamageEntityEvent event) {
        ListenersHub.weaponevent = event;
        lh.WeaponDamageEntityInitialize();
    }
    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event){
        ListenersHub.playerinteract = event;
        lh.PlayerInteractInitialize();
    }
    @EventHandler
    public void PlayerBreakBlock(BlockBreakEvent event){
    	ListenersHub.blockbreak = event;
    	lh.PlayerBreakBlockInitialize();
    }
    @EventHandler
    public void PlayerChatEvent(AsyncPlayerChatEvent event){
    	ListenersHub.playerchat = event;
    	lh.PlayerChatInitialize();
    }
    @EventHandler
    public void PlayerCommandEvent(PlayerCommandPreprocessEvent event){
    	ListenersHub.playercommand = event;
    	lh.PlayerCommandEvent();
    }
    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    	CommandCentral cc = new CommandCentral();
    	try {
			cc.CommandInitiate(sender, cmd, label, args);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return true;
    }
    public void Initialize() throws IOException{
		if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.gWarsSuite.Listeners Listener = new tk.genesishub.gFeatures.gWarsSuite.Listeners();
			Listener.onDisable();
			gWarsSuitePlugin.setPluginState(PluginState.DISABLE);
		}
		if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.gDestroyCritical.Listeners Listener = new tk.genesishub.gFeatures.gDestroyCritical.Listeners();
			Listener.onDisable();
			gDestroyCriticalPlugin.setPluginState(PluginState.DISABLE);
		}
		if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.GenesisAccess.Main Listener = new tk.genesishub.gFeatures.GenesisAccess.Main();
			Listener.onDisable();
			GenesisAccessPlugin.setPluginState(PluginState.DISABLE);
		}
		if(gFactionsPlugin.getState().equals(PluginState.ENABLE)){
			gFactionsPlugin.setPluginState(PluginState.DISABLE);
		}
		if(gHubPlugin.getState().equals(PluginState.ENABLE)){
			gHubPlugin.setPluginState(PluginState.DISABLE);
		}
		if(GenesisBackupPlugin.getState().equals(PluginState.ENABLE)){
			GenesisBackupPlugin.setPluginState(PluginState.DISABLE);
		}
		if(GenesisEconomyPlugin.getState().equals(PluginState.ENABLE)){
			GenesisEconomyPlugin.setPluginState(PluginState.DISABLE);
			tk.genesishub.gFeatures.GenesisEconomy.Listeners listeners = new tk.genesishub.gFeatures.GenesisEconomy.Listeners();
			listeners.onDisable();
		}
		if(GenesisScorePlugin.getState().equals(PluginState.ENABLE)){
			GenesisScorePlugin.setPluginState(PluginState.DISABLE);
		}
		if(CameraStudioPlugin.getState().equals(PluginState.ENABLE)){
			CameraStudioPlugin.setPluginState(PluginState.DISABLE);
		}
		sm.Disable(Skripts.gEssentialsHub);
		sm.Disable(Skripts.gEssentialsMinigames);
		sm.Disable(Skripts.gEssentialsFactions);
		sm.Disable(Skripts.gEssentialsGlobal);
		//sm.Disable(Skripts.gMMO);
		sm.Disable(Skripts.gCrates);
	}
}
