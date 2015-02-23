package tk.genesishub.gFeatures.Listeners;

import java.io.FileNotFoundException;
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

import ch.njol.skript.Skript;

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
	
	String EnteredKey = "Hi!";
	String ProductKey = "gFE-69a-123-abc";
	
	ListenersHub lh = new ListenersHub();
	
	@Override
    public void onEnable() { //What to do on server load/reload
        getLogger().info("[gFeatures] Starting gFeatures...");
        Enabler e = new Enabler();
        try {
			e.Enable();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
        getLogger().info("[gFeatures] Complete! gFeatures has loaded. All clear for take off!");    
        if (Bukkit.getPluginManager().getPlugin("Skript") != null) {
        	// put all code related to Skript here!
        	Skript.registerEffect(EffTitle.class, new String[] { "send title %string% in %world%" }); //Test thing
        }
        //Product Key System
        if (EnteredKey.equals(ProductKey));
        //To-Do
        }
 
    @Override
    public void onDisable() { //What to do on server unload/reload
       getLogger().info("[gFeatures] gFeatures is turning off...!");  
       Disabler d = new Disabler();
       
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
}
