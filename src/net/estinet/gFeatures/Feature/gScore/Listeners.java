package net.estinet.gFeatures.Feature.gScore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
	final Scored s = new Scored();
	public void onEnable(){
		Bukkit.getLogger().info("gScore is enabled! Stuff will happen!");
	}
	public void onDisable(){
		Bukkit.getLogger().info("gScore is disabled! :(");
	}
	@SuppressWarnings("deprecation")
	public void onPlayerJoin(final PlayerJoinEvent event) throws IllegalArgumentException, IllegalStateException{
		for(Player ps : Bukkit.getServer().getOnlinePlayers()){
			ps.setScoreboard(s.Initialize(ps));
		}
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
					try {
						event.getPlayer().setScoreboard(s.Initialize(event.getPlayer()));
				} catch (IllegalArgumentException e) {
				} catch (IllegalStateException e) {
				}
        	}
        }, 100L);
	}
	@SuppressWarnings("deprecation")
	public void onPlayerLeave(PlayerQuitEvent event) throws IllegalArgumentException, IllegalStateException{
		for(Player ps : Bukkit.getServer().getOnlinePlayers()){
			ps.setScoreboard(s.Initialize(ps));
		}
	}
	public void set(Player p) throws IllegalArgumentException, IllegalStateException{
		p.setScoreboard(s.Initialize(p));
	}
}
