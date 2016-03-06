package net.estinet.gFeatures.Feature.gHub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerJoinEvent;

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
	public void onPlayerJoin(final PlayerJoinEvent event){
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	@SuppressWarnings("deprecation")
			public void run(){
        		Location loc = new Location(Bukkit.getServer().getWorld("GenesisHub"), -2036, 168, 1963);
        		event.getPlayer().playEffect(loc, Effect.RECORD_PLAY, Material.RECORD_7.getId());
        		event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Now playing: Vexento-Pixel Party");
        		event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "Make sure you get the resource pack!");
           }
        }, 60L);
	}
}
