package net.estinet.gFeatures.Feature.CTF.EventBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Action;
import net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc.Respawn;


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

public class Dead {
	Respawn r = new Respawn();
	public void init(Player p){
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable(){ public void run() {
	            p.setHealth(20);
	    }});
		try{
		if(Basic.blueflagger.getName().equals(p.getName())){
			Action.sendAllTitle(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + " has died!", ChatColor.GOLD + "" + ChatColor.BOLD + "The orange flag has been returned.", 20, 40, 20);
			Basic.blueflagger = null;
		}
		}
		catch(Exception e){}
		try{
		if(Basic.orangeflagger.getName().equals(p.getName())){
			Action.sendAllTitle(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + p.getName() + " has died!", ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "The blue flag has been returned.", 20, 40, 20);
			Basic.orangeflagger = null;
		}
		}
		catch(Exception e){}
		p.setGameMode(GameMode.SPECTATOR);
		ActionAPI aapi = new ActionAPI();
		aapi.sendActionbar(p, ChatColor.RED + "Respawning in 5 seconds...");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		r.respawn(p);
        	}
        }, 100L);
	}
}
