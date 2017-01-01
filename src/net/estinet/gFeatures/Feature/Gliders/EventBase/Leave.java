package net.estinet.gFeatures.Feature.Gliders.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.Gliders.Basic;
import net.estinet.gFeatures.Feature.Gliders.Mode;
import net.estinet.gFeatures.Feature.Gliders.EventBase.GameFunc.Action;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class Leave {
	public void init(PlayerQuitEvent event){
		Basic.modes.remove(event.getPlayer().getUniqueId());
		Basic.kills.remove(event.getPlayer().getUniqueId());
		Basic.deaths.remove(event.getPlayer().getUniqueId());
		Basic.teams.remove(event.getPlayer().getUniqueId());
		try{
		if(Basic.flagger.getName().equals(event.getPlayer().getName())){
			Basic.flagger = null;
			Action.sendAllTitle(ChatColor.BOLD + "" + ChatColor.BOLD + event.getPlayer().getName() + " has left!", ChatColor.BOLD + "The flag has been returned.", 20, 40, 20);
		}
		}catch(NullPointerException e){}
		if(Bukkit.getOnlinePlayers().size() == 2 && Basic.mode.equals(Mode.STARTED)){
			Bukkit.broadcastMessage(ChatColor.AQUA + "[Gliders] " + ChatColor.WHITE + "Not enough players! Server restarting. :/");
			CliotePing cp = new CliotePing();
    		for(Player p : Bukkit.getOnlinePlayers()){
    			cp.sendMessage("redirect " + p.getName() + " MinigameHub", "Bungee");
    		}
			Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	        	public void run(){
	        		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "stop");
	        	}
	        }, 300L);
		}
	}
}
