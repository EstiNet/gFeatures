package tk.genesishub.gFeatures.Listeners;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

public class ListenersHub {
	PlayerJoinEvent playerjoin;
	PlayerQuitEvent playerquit;
	PlayerMoveEvent playermove;
	PlayerDeathEvent playerdeath;
	PlayerRespawnEvent playerrespawn;
	EntityDamageByEntityEvent damageentity;
	WeaponDamageEntityEvent weaponevent;
	PlayerInteractEvent playerinteract;
	public ListenersHub(PlayerJoinEvent event){
		playerjoin = event;
	}
	public ListenersHub(PlayerQuitEvent event){
		playerquit = event;
	}
	public ListenersHub(PlayerMoveEvent event){
		playermove = event;
	}
	public ListenersHub(PlayerRespawnEvent event){
		playerrespawn = event;
	}
	public ListenersHub(PlayerDeathEvent event){
		playerdeath = event;
	}
	public ListenersHub(EntityDamageByEntityEvent event){
		damageentity = event;
	}
	public ListenersHub(WeaponDamageEntityEvent event){
		weaponevent = event;
	}
	public ListenersHub(PlayerInteractEvent event){
		playerinteract = event;
	}
	
}
