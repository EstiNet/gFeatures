package net.genesishub.gFeatures;

import java.util.List;

import org.bukkit.event.Event;
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

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

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
    public void check(String methodname, Event event){
    	List<gFeature> features = Basic.getFeatures();
		for(gFeature feature : features){
			try {
				if(!(feature.getClass().getDeclaredMethod(methodname).equals(null))){
					feature.eventTrigger(event);
				}
			} catch (NoSuchMethodException e) {
			} catch (SecurityException e) {
			}
		}
    }
}
