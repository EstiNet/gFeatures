package net.genesishub.gFeatures;

import org.bukkit.event.player.PlayerInteractEntityEvent;

public interface Events {
	public void onPlayerJoin();
	public void onPlayerLeave();
    public void onPlayerMove();
    public void onPlayerRespawn();
    public void onPlayerDeath();
    public void onEntityDamageByEntity();
    public void onWeaponDamageEntity();
    public void onPlayerInteract();
    public void onPlayerBreakBlock();
    public void onPlayerChat();
    public void onPlayerCommand();
    public void onPlayerOpenInventory();
    public void onPlayerItemHeld();
    public void onInventoryClick();
    public void onEntityExplode();
    public void onFoodLevelChange();
    public void onPlayerDrop();
    public void onPlayerToggleFlight();
    public void onEntityDamage();
    public void onPlayerInteractEntity();
}
