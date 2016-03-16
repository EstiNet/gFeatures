package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Mode;
import net.estinet.gFeatures.Feature.CTF.PlayerMode;
import net.estinet.gFeatures.Feature.CTF.Team;
import net.estinet.gFeatures.Feature.CTF.EventBase.Spectate;
import net.estinet.gFeatures.Feature.CTF.Holo.CTFScore;
import net.estinet.gFeatures.Feature.CTF.Holo.Lobby;
import net.estinet.gFeatures.Feature.CTF.Holo.Loop;
import net.estinet.gFeatures.Feature.CTF.MapsSpec.MapOne;
import net.estinet.gFeatures.Feature.GenesisEconomy.MoneyManager;
import net.estinet.gFeatures.Feature.gMusic.Music;

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

public class StartStop {
	static int tasknum;
	Loop loop = new Loop();
	Action act = new Action();
	Respawn respawn = new Respawn();
	Spectate s = new Spectate();
	Lobby l = new Lobby();
	public void start(){
		tasknum = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
 			public void run(){
 				Basic.orangespawn = new Location(Bukkit.getWorld("CTF"), -167.5, 29.5, 45.5);
 				Basic.bluespawn = new Location(Bukkit.getWorld("CTF"), 105.5, 28.5, 13.5);
 				Basic.orangeflag = new Location(Bukkit.getWorld("CTF"), -175.5, 26.5, 45.5);
 				Basic.blueflag = new Location(Bukkit.getWorld("CTF"), 113.5, 25.5, 13.5);
 				Basic.spectatespawn = new Location(Bukkit.getWorld("CTF"), -27, 35, 2);
 				Basic.orangeafterspawn = new Location(Bukkit.getWorld("CTF"), -171, 21, 45);
 				Basic.blueafterspawn = new Location(Bukkit.getWorld("CTF"), 110, 19, 13);// PLZ DO OOP FOR *** SAKE
 					if(Basic.countdown <= 0){
 						if(Bukkit.getServer().getOnlinePlayers().size() >= 2){
 							Bukkit.getScheduler().cancelTask(tasknum);
 							Basic.mode = Mode.STARTED;
 							for(Player p : Bukkit.getOnlinePlayers()){
 								p.setLevel(0);
 								if(Basic.getOrangeSize() >= Basic.getBlueSize()){
 									Basic.teams.put(p.getUniqueId(), Team.BLUE);
 								}
 								else{
 									Basic.teams.put(p.getUniqueId(), Team.ORANGE);
 								}
 							}
 							
 							for(UUID uuid : Basic.teams.keySet()){
 								for(Player p : Bukkit.getServer().getOnlinePlayers()){
 									if(p.getUniqueId().equals(uuid)){
 										Music m = new Music();
 										m.sendMusic(p, "theme", 100, "Vexento", "Movements", "");
 										p.playSound(p.getLocation(), "theme", 100, 1);
 										respawn.respawn(p);
 									}
 								}
 							}
 							
 							Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	 					        	public void run(){
	 					        		Bukkit.getWorld("CTF").spawn(Basic.blueflag, EnderCrystal.class);
	 					        		Bukkit.getWorld("CTF").spawn(Basic.orangeflag, EnderCrystal.class);
	 					        	}
	 					        }, 45L);
 							
 							
 							Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
 					        	public void run(){
 					        		for(Player p : Bukkit.getServer().getOnlinePlayers()){
 					        			Music m = new Music();
 										m.sendMusic(p, "theme", 100, "Vexento", "Movements", "");
 					        		}
 					        		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
 		 					        	public void run(){
 		 					        		stop();
 		 					        	}
 		 					        }, 4500L);
 					        	}
 					        }, 4500L);
 							FinishStart fs = new FinishStart();
 							fs.finish();
 							recursive();
 						}
 						else{
 							Bukkit.broadcastMessage(ChatColor.AQUA + "[CTF] " + ChatColor.WHITE + "Not enough players! Counter restarting. :/");
 							Basic.mode = Mode.WAITING;
 							Basic.countdown = 60;
 							Bukkit.getScheduler().cancelTask(tasknum);
 							for(Player p : Bukkit.getServer().getOnlinePlayers()){
 		              			p.setScoreboard(l.Initialize(p));
 		              			p.setLevel(Basic.countdown);
 		              			p.playSound(p.getLocation(), Sound.WEATHER_RAIN, 50, 50);
 		              		}
 						}
 					}
 					else{
 					loop.goThrough();
              		for(Player p : Bukkit.getServer().getOnlinePlayers()){
              			p.setScoreboard(l.Initialize(p));
              			p.setLevel(Basic.countdown);
              			p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HARP, 50, 50);
              		}
              		}
              		Basic.countdown--;
                }
    }, 0, 20L);
	}
	public void stop(){
		for(Player p : Bukkit.getOnlinePlayers()){
			Basic.modes.remove(p.getUniqueId());
			Basic.modes.put(p.getUniqueId(), PlayerMode.SPECTATE);
			s.handler(p);
			//Show their stats
			p.sendMessage(ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "-----" + ChatColor.RESET + ChatColor.GREEN + "" + ChatColor.BOLD + "Stats" + ChatColor.WHITE + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "-----");
			p.sendMessage(ChatColor.AQUA + "Kills: " + Basic.kills.get(p.getUniqueId()));
			p.sendMessage(ChatColor.AQUA + "Deaths: " + Basic.deaths.get(p.getUniqueId()));
			p.sendMessage(ChatColor.AQUA + "Flag Captures: " + Basic.flagcaptures.get(p.getUniqueId()));
			int clupic = (Basic.flagcaptures.get(p.getUniqueId()) * 20) + (Basic.kills.get(p.getUniqueId()) * 2);
			p.sendMessage(ChatColor.GREEN + "Total Clupic Earned: " + clupic);
			p.sendMessage(ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "---------------");
			MoneyManager mm = new MoneyManager();
			Thread thr = new Thread(new Runnable(){
				public void run(){
					try {
						mm.giveMoney(p, clupic);
					}  
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			thr.start();
		}
		Basic.mode = Mode.ENDED;
		if(Basic.orangeflags > Basic.blueflags){
			Action.sendAllTitle(ChatColor.GOLD + "The orange team won!", ChatColor.BOLD + Integer.toString(Basic.orangeflags) + " flags captured.", 20, 40, 20);
		}
		else if(Basic.orangeflags < Basic.blueflags){
			Action.sendAllTitle(ChatColor.DARK_AQUA + "The blue team won!", ChatColor.BOLD + Integer.toString(Basic.blueflags) + " flags captured.", 20, 40, 20);
		}
		else{
			Action.sendAllTitle(ChatColor.BOLD + "Both teams tied!", "", 20, 40, 20);
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		//Kick player off to hub
        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
        	}
        }, 1000L);
	}
	public void recursive(){
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
	        	public void run(){
	        		if(Basic.mode.equals(Mode.STARTED)){
	        		if(Basic.seconds == 0){
	        			Basic.seconds = 50;
	        			Basic.minutes -= 1;
	        		}
	        		else{
	        			Basic.seconds -= 10;
	        		}
	        		for(Player p : Bukkit.getOnlinePlayers()){
	        			CTFScore ctfs = new CTFScore();
	        			p.setScoreboard(ctfs.Initialize(p));
	        		}
	        		recursive();
	        		}
	        	}
	        }, 200L);
	}
}
