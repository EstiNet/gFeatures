package tk.genesishub.gWarsSuite;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.bukkit.Server;
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
import org.bukkit.scheduler.BukkitScheduler;
import org.xml.sax.SAXException;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
/*
   gWarsSuite2 Version 7.4
   Bukkit Plugin by the GenesisHub Team
   Copyright 2015 DolphinBox.net

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
	Summon summon = new Summon();
	HitManager hm = new HitManager();
	DeathManager dm = new DeathManager();
	Constants cons = new Constants();
	JoinManager jm = new JoinManager();
	LeaveManager lm = new LeaveManager();
	CommandHub ch = new CommandHub();
	ListTeams lt = new ListTeams();
	TierSelectionMenu tsm = new TierSelectionMenu();
	GameMenu gm = new GameMenu();
	FileManager fm = new FileManager();
	LobbyTeleport ltp = new LobbyTeleport();
	TotallyNotFlyingBoats tnfb = new TotallyNotFlyingBoats();
	
	@Override
    public void onEnable() { //What to do on server load/reload
        getLogger().info("[gFeatures] Starting gFeatures...");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
        fm.EnablerCheck();
        getLogger().info("[gFeatures] Complete! gFeatures has loaded. All clear for take off!");    
        }
 
    @Override
    public void onDisable() { //What to do on server unload/reload
       getLogger().info("[gFeatures] gFeatures is turning off...!");  
    }
    JavaPlugin plugin;
    Server server;
    BukkitScheduler sched;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws InterruptedException, ParserConfigurationException, TransformerException, SAXException, IOException{
    	jm.JoinManage(event);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
    	lm.ManageLeave(event);
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
    	ltp.Initalize(event);
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onPlayerRespawn(PlayerRespawnEvent event) throws InterruptedException{
    	Constants.arena.remove(event.getPlayer().getName());
    	getLogger().info(event.getPlayer().getName() + " has died.");
    	lm.ManageRespawn(event);
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
    	Constants.arena.remove(event.getEntity().getName());
    	dm.ManageDeath(event.getEntity(), event);
    }
    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        hm.EntityDamageByOther(event);
    }
        @EventHandler
        public void onHit1(WeaponDamageEntityEvent event) {
            hm.WeaponDamage(event);
        }
        @Override
        public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    		try {
				ch.CommandInitiate(sender, cmd, label, args);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
        }
        @EventHandler
        public void PlayerInteract(PlayerInteractEvent event){
        	tsm.Initialize(event);
        	tnfb.Initialize(event);
        	gm.Initialize(event.getPlayer());
       	 }
        public void log(String log){
        	getLogger().info(log);
        }
        public boolean getIsland(int X, int Z){
        	if((X == 551 || (X > 551 && !(X>(551-5)))||(X < 551 && !(X<551-5)))&&(Z == 421 || (Z > 421 && !(Z>(421-5)))||(Z < 421 && !(Z<421-5)))){
        		return true;
        	}
			return false;
        	
        }
        public boolean getTown(int X, int Z){
        	if((X == 496 || (X > 496 && !(X>(496-5)))||(X < 496 && !(X<486-5)))&&(Z == 177 || (Z > 177 && !(Z>(177-5)))||(Z < 177 && !(Z<177-5)))){
        		return true;
        	}
			return false;
        }
}
