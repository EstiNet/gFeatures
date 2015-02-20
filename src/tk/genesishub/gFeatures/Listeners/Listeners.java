package tk.genesishub.gFeatures.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
	
	@Override
    public void onEnable() { //What to do on server load/reload
        getLogger().info("[gFeatures] Starting gFeatures...");
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
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
    	ListenersHub lh = new ListenersHub(event);
    	lh.PlayerJoinInitialize();
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
    	ListenersHub lh = new ListenersHub(event);
    	lh.PlayerQuitInitialize();
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
    	ListenersHub lh = new ListenersHub(event);
    	lh.PlayerMoveInitialize();
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	ListenersHub lh = new ListenersHub(event);
    	lh.PlayerRespawnInitialize();
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
    	ListenersHub lh = new ListenersHub(event);
    	lh.PlayerDeathInitialize();
    }
    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
    	ListenersHub lh = new ListenersHub(event);
    	lh.EntityDamageEntityInitialize();
    }
    @EventHandler
    public void onHit1(WeaponDamageEntityEvent event) {
        ListenersHub lh = new ListenersHub(event);
        lh.WeaponDamageEntityInitialize();
    }
    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event){
        ListenersHub lh = new ListenersHub(event);
        lh.PlayerInteractInitialize();
    }
    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    	CommandCentral cc = new CommandCentral();
    	try {
			cc.CommandInitiate(sender, cmd, label, args);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }
}
