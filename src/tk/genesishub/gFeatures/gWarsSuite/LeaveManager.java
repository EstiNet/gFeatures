package tk.genesishub.gFeatures.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

public class LeaveManager{
	Constants cons = new Constants();
	Administration admin = new Administration();
	public void ManageLeave(PlayerQuitEvent event){
		Player player = event.getPlayer();
    	Constants.ot.remove(player.getName());
    	Constants.bt.remove(player.getName());
    	Constants.arena.remove(player.getName());
    	Constants.gunin.remove(player.getName());
    	Constants.spectate.remove(player.getName());
	}
	public void ManageRespawn(final PlayerRespawnEvent event){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	    scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	    	public void run(){
	    		admin.clearArena(event.getPlayer());
	    		admin.clearGunin(event.getPlayer());
	       }
	    }, 20L);
		final Player p = (Player) event.getPlayer();
    	if(Constants.bt.contains(p.getName())){ 
             scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
                 @Override
                 public void run() {
                	p.getInventory().clear();
                 	ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)3);
                    p.getInventory().setHelmet(wool);
                    ItemStack chest = new ItemStack(Material.CHEST);
                    ItemMeta im = chest.getItemMeta();
                    im.setDisplayName(ChatColor.AQUA + "Select Gun");
                    chest.setItemMeta(im);
                    p.getInventory().setItemInHand(chest);
                	 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " spawn");
                 }
             }, 12L);
    	}
    	else if(Constants.ot.contains(p.getName())){
    		scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
                @Override
                public void run() {
                p.getInventory().clear();
               	 ItemStack wool = new ItemStack(Material.STAINED_GLASS, 1, (byte)1);
               	 ItemStack chest = new ItemStack(Material.CHEST);
                 ItemMeta im = chest.getItemMeta();
                 im.setDisplayName(ChatColor.AQUA + "Select Gun");
                 chest.setItemMeta(im);
                 p.getInventory().setItemInHand(chest);
                 p.getInventory().setHelmet(wool);
               	 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sudo " + p.getName() + " spawn");
                }
            }, 12L);
    	}
	}
}
