package net.genesishub.gFeatures;

import net.genesishub.gFeatures.API.PlayerStats.ConfigHub;
import net.genesishub.gFeatures.Configuration.LoadConfig;
import net.genesishub.gFeatures.Configuration.SetupConfig;

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

public class Listeners extends JavaPlugin implements Listener{
	public static final String version = "2.3.3";
	
	PluginManager pm = getServer().getPluginManager();
	Enabler enable = new Enabler();
	Disabler disable = new Disabler();
	Library library = new Library();
	CommandLibrary commands = new CommandLibrary();
	Setup setup = new Setup();
	ConfigHub ch = new ConfigHub();
	
	@Override
	public void onEnable(){
	    pm.registerEvents(this, this);
		getLogger().info("_________________________________________________________________________");
		getLogger().info("[gFeatures] Initalizing gFeatures Core");
		getLogger().info("[gFeatures] This server is running gFeatures Core Version: " + version);
		getLogger().info("[gFeatures] Starting modules...");
		setup.onSetup();
		SetupConfig.setup();
		LoadConfig.load();
		enable.onEnable();
		Basic.addPlayerSection("Setup", "DO NOT REMOVE!");
		ch.setupConfig();
		ch.loadConfig();
		getLogger().info("[gFeatures] Complete! Continuing Server startup routine...");
		getLogger().info("_________________________________________________________________________");
	}
	@Override
	public void onDisable(){
		getLogger().info("_________________________________________________________________________");
		getLogger().info("[gFeatures] Stopping gFeatures Core!");
		getLogger().info("[gFeatures] This server is running gFeatures Core Version: " + version);
		getLogger().info("[gFeatures] Turning off modules...");
		disable.onDisable();
		getLogger().info("[gFeatures] Complete!");
		getLogger().info("_________________________________________________________________________");
	}
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
    	library.onPlayerJoin(event);
    	ch.addPlayerSection(event.getPlayer());
    	Basic.getgPlayer(event.getPlayer().getName()).setPlayer(event.getPlayer());
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
    	library.onPlayerLeave(event);
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
    	library.onPlayerMove(event);
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	library.onPlayerRespawn(event);
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
    	library.onPlayerDeath(event);
    }
    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
    	library.onEntityDamageByEntity(event);
    }
    @EventHandler
    public void onHit1(WeaponDamageEntityEvent event) {
        library.onWeaponDamageEntity(event);
    }
    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event){
        library.onPlayerInteract(event);
    }
    @EventHandler
    public void PlayerBreakBlock(BlockBreakEvent event){
    	library.onPlayerBreakBlock(event);
    }
    @EventHandler
    public void PlayerChatEvent(AsyncPlayerChatEvent event){
    	library.onPlayerChat(event);
    }
    @EventHandler
    public void PlayerCommandEvent(PlayerCommandPreprocessEvent event){
    	library.onPlayerCommand(event);
    }
    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    	commands.Commands(sender, cmd, label, args);
        return true;
    }
}
