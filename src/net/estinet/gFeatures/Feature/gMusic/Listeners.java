package net.estinet.gFeatures.Feature.gMusic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class Listeners {
	public void onEnable(){
		Bukkit.getLogger().info("[gMusic] Hey! Just arrived at EstiNet! *gMusic");
	}
	public void onDisable(){
		Bukkit.getLogger().info("[gMusic] Well, my time here on EstiNet is gone. Bye!");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		final Player p = event.getPlayer();
		 final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
     	scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
         	public void run(){
         		/*p.sendMessage(ChatColor.DARK_AQUA+"Do /music to open up the music menu!");
        		p.sendMessage(ChatColor.DARK_AQUA+"Make sure you have the resource pack! It might take a while to download.");
        		p.sendMessage(ChatColor.DARK_AQUA+"DISCLAIMER:");
        		p.sendMessage(ChatColor.DARK_AQUA+"We haven't found a way to actually stop the music.");
        		p.sendMessage(ChatColor.DARK_AQUA+"Don't play a song while another is playing or else they will play at the same time.");
        		p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "For all songs other than the minecraft ones, you'll need a resource pack.");*/
        		//p.sendMessage(ChatColor.GOLD + "https://www.dropbox.com/s/cguhado3piwo9fb/GenesisMusic.zip?dl=1");
            }
         }, 20L);
	}
}
