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
	tk.genesishub.gFeatures.gWarsSuite.Listeners gWars = new tk.genesishub.gFeatures.gWarsSuite.Listeners();
	PlayerJoinEvent playerjoin;
	PlayerQuitEvent playerquit;
	PlayerMoveEvent playermove;
	PlayerDeathEvent playerdeath;
	PlayerRespawnEvent playerrespawn;
	EntityDamageByEntityEvent damageentity;
	WeaponDamageEntityEvent weaponevent;
	PlayerInteractEvent playerinteract;
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
	protected void PlayerJoinInitialize(){
		inTo();
		try {
			gWars.onPlayerJoin(playerjoin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void PlayerQuitInitialize(){
		inTo();
		try {
			gWars.onPlayerQuit(playerquit);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerMoveInitialize(){
		inTo();
		try {
			gWars.onPlayerMove(playermove);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerRespawnInitialize(){
		inTo();
		try {
			gWars.onPlayerRespawn(playerrespawn);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerDeathInitialize(){
		inTo();
		try {
			gWars.onPlayerDeath(playerdeath);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void EntityDamageEntityInitialize(){
		inTo();
		try {
			gWars.onEntityDamageByEntity(damageentity);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void WeaponDamageEntityInitialize(){
		inTo();
		try {
			gWars.onWeaponDamageEntity(weaponevent);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	protected void PlayerInteractInitialize(){
		inTo();
		try {
			gWars.onPlayerInteract(playerinteract);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	private void inTo(){
		
	}
}
