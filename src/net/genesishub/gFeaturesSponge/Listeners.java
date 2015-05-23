package net.genesishub.gFeaturesSponge;

import net.genesishub.gFeaturesSponge.API.PlayerStats.ConfigHub;
import net.genesishub.gFeaturesSponge.Configuration.LoadConfig;
import net.genesishub.gFeaturesSponge.Configuration.SetupConfig;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.block.BlockBreakEvent;
import org.spongepowered.api.event.entity.player.PlayerDeathEvent;
import org.spongepowered.api.event.entity.player.PlayerInteractEvent;
import org.spongepowered.api.event.entity.player.PlayerJoinEvent;
import org.spongepowered.api.event.entity.player.PlayerMoveEvent;
import org.spongepowered.api.event.entity.player.PlayerQuitEvent;
import org.spongepowered.api.event.entity.player.PlayerRespawnEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;
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

@Plugin(id = "gFeatures", name = "gFeatures", version = "2.3.2")
public class Listeners{
	public static final String version = "2.3.2";
	
	@Inject
	Game game;
    @Inject
	Logger logger;
	
	Enabler enable = new Enabler();
	Disabler disable = new Disabler();
	Library library = new Library();
	CommandLibrary commands = new CommandLibrary();
	Setup setup = new Setup();
	ConfigHub ch = new ConfigHub();
	
	@Subscribe
	public void onEnable(PreInitializationEvent event){
	    logger.info("_________________________________________________________________________");
		logger.info("[gFeatures] gFeatures enabled!");
		logger.info("[gFeatures] This gFeatures installation is running core: " + version);
		logger.info("[gFeatures] Turning on Features...");
		setup.onSetup();
		SetupConfig.setup();
		LoadConfig.load();
		enable.onEnable();
		Basic.addPlayerSection("Setup", "DO NOT REMOVE!");
		ch.setupConfig();
		ch.loadConfig();
		logger.info("[gFeatures] Complete!");
		logger.info("_________________________________________________________________________");
	}
	@Subscribe
	public void onDisable(ServerStoppingEvent event){
		logger.info("_________________________________________________________________________");
		logger.info("[gFeatures] gFeatures disabled!");
		logger.info("[gFeatures] This gFeatures installation is running core: " + version);
		logger.info("[gFeatures] Turning off Features...");
		disable.onDisable();
		logger.info("[gFeatures] Complete!");
		logger.info("_________________________________________________________________________");
	}
	@Subscribe
    public void onPlayerJoin(PlayerJoinEvent event){
    	library.onPlayerJoin(event);
    	ch.addPlayerSection(event.getPlayer());
    	Basic.getgPlayer(event.getPlayer().getName()).setPlayer(event.getPlayer());
    }
    @Subscribe
    public void onPlayerLeave(PlayerQuitEvent event){
    	library.onPlayerLeave(event);
    }
    @Subscribe
    public void onPlayerMove(PlayerMoveEvent event){
    	library.onPlayerMove(event);
    }
    @Subscribe
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	library.onPlayerRespawn(event);
    }
    @Subscribe
    public void onDeath(PlayerDeathEvent event){
    	library.onPlayerDeath(event);
    }
    @Subscribe
    public void onHit(EntityDamageByEntityEvent event) {
    	library.onEntityDamageByEntity(event);
    }
    /*@Subscribe
    public void onHit1(WeaponDamageEntityEvent event) {
        library.onWeaponDamageEntity(event);
    }*/
    @Subscribe
    public void PlayerInteract(PlayerInteractEvent event){
        library.onPlayerInteract(event);
    }
    @Subscribe
    public void PlayerBreakBlock(BlockBreakEvent event){
    	library.onPlayerBreakBlock(event);
    }
    @Subscribe
    public void PlayerChatEvent(PlayerChatEvent event){
    	library.onPlayerChat(event);
    }
    @Subscribe
    public void PlayerCommandEvent(PlayerCommandPreprocessEvent event){
    	library.onPlayerCommand(event);
    }
    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    	commands.Commands(sender, cmd, label, args);
        return true;
    }
}
