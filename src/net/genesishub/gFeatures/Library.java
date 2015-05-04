package net.genesishub.gFeatures;

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
	public void onPlayerJoin(PlayerJoinEvent event){}
	public void onPlayerLeave(PlayerQuitEvent event){}
    public void onPlayerMove(PlayerMoveEvent event){}
    public void onPlayerRespawn(PlayerRespawnEvent event){}
    public void onPlayerDeath(PlayerDeathEvent event){}
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {}
    public void onWeaponDamageEntity(WeaponDamageEntityEvent event) {}
    public void onPlayerInteract(PlayerInteractEvent event){}
    public void onPlayerBreakBlock(BlockBreakEvent event){}
    public void onPlayerChat(AsyncPlayerChatEvent event){}
    public void onPlayerCommand(PlayerCommandPreprocessEvent event){}
}
