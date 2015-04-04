package tk.genesishub.gFeatures.gMusic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class Listeners {
	public void onEnable(){
		Bukkit.getLogger().info("[gMusic] Hey! Just arrived at GenesisHub! *gMusic");
	}
	public void onDisable(){
		Bukkit.getLogger().info("[gMusic] Well, my time here on GenesisHub is gone. Bye!");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		final Player p = event.getPlayer();
		 final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
     	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
         	public void run(){
         		p.sendMessage(ChatColor.DARK_AQUA+"Do /music to open up the music menu!");
        		p.sendMessage(ChatColor.DARK_AQUA+"Make sure you have the resource pack! It might take a while to download.");
        		p.sendMessage(ChatColor.DARK_AQUA+"DISCLAIMER:");
        		p.sendMessage(ChatColor.DARK_AQUA+"We haven't found a way to actually stop the music.");
        		p.sendMessage(ChatColor.DARK_AQUA+"Don't play a song while another is playing or else they will play at the same time.");
            }
         }, 20L);
	}
}
