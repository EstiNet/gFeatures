package net.estinet.gFeatures.Feature.Grasslands;

import net.estinet.gFeatures.Feature.Grasslands.Scoreboard.Countdown;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

public class GameStart {
	Countdown cd = new Countdown();
	static int tasknum;
    int iter = 60;
		
	public void check(){
		if(Enable.lobby.getPlayers().size() >= 2){
			start();
		}
		else{
			Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "When there are 2 players on the server, the game will start!");
		}
	}
	public void start(){
		Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "The game will be starting in 1 minute.");
         		tasknum = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
         			public void run(){
         					if(iter <= 0){
         						Bukkit.getScheduler().cancelTask(tasknum);
         						teleportPlayers();
         					}
         					else{
	                  		for(Player p : Bukkit.getServer().getOnlinePlayers()){
	                  			p.setScoreboard(cd.get(p, iter));
	                  			p.setLevel(iter);
	                  			p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 50, 50);
	                  		}
	                  		}
	                  		iter--;
	                    }
	        }, 0, 20L);
         for(int eggs = 100; eggs != 0; eggs--){
        	int randomx = (int) Math.floor(Math.random()*156);
        	int randomz = (int) Math.floor(Math.random()*60);
        	Location loc = new Location(Bukkit.getServer().getWorld("Grasslands"), randomx-20, 35, randomz);
        	loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.MONSTER_EGG));
        	Bukkit.getLogger().info("Dropped egg at: x: " + randomx + "-20 z: " + randomz);
         }
	}
	public void teleportPlayers(){
		
	}
	public void checkLeave(){
		if(Enable.lobby.getPlayers().size() >= 1){
			Bukkit.getServer().broadcastMessage("[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Grasslands" + ChatColor.RESET +"]" + ChatColor.GOLD + "Not enough players! The countdown will stop.");
			Bukkit.getScheduler().cancelTask(tasknum);
		}
	}
}
