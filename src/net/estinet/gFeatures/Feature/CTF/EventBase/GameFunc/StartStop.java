package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
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
				boolean nu = true;
				Basic.orangespawn = new Location(Bukkit.getWorld("CTF"), -167.5, 29.5, 45.5);
				Basic.bluespawn = new Location(Bukkit.getWorld("CTF"), 105.5, 28.5, 13.5);
				Basic.orangeflag = new Location(Bukkit.getWorld("CTF"), -175.5, 26.5, 45.5);
				Basic.blueflag = new Location(Bukkit.getWorld("CTF"), 113.5, 25.5, 13.5);
				Basic.spectatespawn = new Location(Bukkit.getWorld("CTF"), -27, 35, 2);
				Basic.orangeafterspawn = new Location(Bukkit.getWorld("CTF"), -171, 21, 45);
				Basic.blueafterspawn = new Location(Bukkit.getWorld("CTF"), 110, 19, 13);// PLZ DO OOP FOR *** SAKE
				if(Basic.countdown <= 0){
					if(Bukkit.getServer().getOnlinePlayers().size() >= 2){
						CliotePing cp = new CliotePing();
						cp.sendMessage("mgstart", "Bungee");
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
							p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 25, 25);
						}
					}
				}
				else{
					if(Bukkit.getServer().getOnlinePlayers().size() >= 2){
						loop.goThrough();
						for(Player p : Bukkit.getServer().getOnlinePlayers()){
							p.setScoreboard(l.Initialize(p));
							p.setLevel(Basic.countdown);
							p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HARP, 50, 50);
						}
					}
					else{
						Bukkit.broadcastMessage(ChatColor.AQUA + "[CTF] " + ChatColor.WHITE + "Not enough players! Counter restarting. :/");
						Basic.mode = Mode.WAITING;
						Basic.countdown = 60;
						Bukkit.getScheduler().cancelTask(tasknum);
						for(Player p : Bukkit.getServer().getOnlinePlayers()){
							p.setScoreboard(l.Initialize(p));
							p.setLevel(Basic.countdown);
						}
						nu = false;
					}
				}
				if(nu){
					Basic.countdown--;
				}
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
			p.sendMessage(ChatColor.AQUA + "Participation: +10 clupic");
			p.sendMessage(ChatColor.AQUA + "Kills: " + Basic.kills.get(p.getUniqueId()));
			p.sendMessage(ChatColor.AQUA + "Deaths: " + Basic.deaths.get(p.getUniqueId()));
			p.sendMessage(ChatColor.AQUA + "Flag Captures: " + Basic.flagcaptures.get(p.getUniqueId()));
			int clupic = 0;
			if(Basic.isInBlue(p)){
				p.sendMessage(ChatColor.AQUA + "Team Flag Captures: " + Basic.blueflags);
				clupic = (Basic.blueflags * 10) + ((Basic.kills.get(p.getUniqueId()) * 5) + 10);
			}
			else{
				p.sendMessage(ChatColor.AQUA + "Team Flag Captures: " + Basic.orangeflags);
				clupic = (Basic.orangeflags * 10) + ((Basic.kills.get(p.getUniqueId()) * 5) + 10);
			}
			p.sendMessage(ChatColor.GREEN + "Total Clupic Earned: " + clupic);
			p.sendMessage(ChatColor.STRIKETHROUGH + "" + ChatColor.BOLD + "---------------");
			MoneyManager mm = new MoneyManager();
			final int nums = clupic;
			Thread thr = new Thread(new Runnable(){
				public void run(){
					try {
						mm.giveMoney(p, nums);
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
				CliotePing cp = new CliotePing();
				for(Player p : Bukkit.getOnlinePlayers()){
					cp.sendMessage("redirect " + p.getName() + " MinigameHub", "Bungee");
				}

				Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
					public void run(){
						if(Bukkit.getOnlinePlayers().size() == 0){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
						}
						for(Player p : Bukkit.getOnlinePlayers()){
							cp.sendMessage("redirect " + p.getName() + " MinigameHub", "Bungee");
						}
					}
				}, 80L, 80L);

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
