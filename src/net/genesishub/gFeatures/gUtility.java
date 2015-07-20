package net.genesishub.gFeatures;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;

public class gUtility extends Extension{

	public gUtility(String featurename, String d) {
		super(featurename, d, ExtensionsType.Utility);
	}
	public void enable(){}
	public void disable(){}
	public void eventTrigger(Event event){}
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args){}
	public void onPlayerJoin(){}
	public void onPlayerLeave(){}
    public void onPlayerMove(){}
    public void onPlayerRespawn(){}
    public void onPlayerDeath(){}
    public void onEntityDamageByEntity() {}
    public void onWeaponDamageEntity() {}
    public void onPlayerInteract(){}
    public void onPlayerBreakBlock(){}
    public void onPlayerChat(){}
    public void onPlayerCommand(){}
    public void onPlayerOpenInventory(){}
    public void onPlayerItemHeld(){}
    public void onInventoryClick(){}
    public void onEntityExplode(){}
    public void onFoodLevelChange(){}
    public void onPlayerDrop(){}
    public void onPlayerToggleFlight(){}
    public void onEntityDamage(){}
}
