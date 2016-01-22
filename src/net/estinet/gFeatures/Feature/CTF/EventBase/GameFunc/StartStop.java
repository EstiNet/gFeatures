package net.estinet.gFeatures.Feature.CTF.EventBase.GameFunc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Player;

import com.earth2me.essentials.api.UserDoesNotExistException;

import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Mode;
import net.estinet.gFeatures.Feature.CTF.PlayerMode;
import net.estinet.gFeatures.Feature.CTF.Team;
import net.estinet.gFeatures.Feature.CTF.EventBase.Spectate;
import net.estinet.gFeatures.Feature.CTF.Holo.Lobby;
import net.estinet.gFeatures.Feature.CTF.Holo.Loop;
import net.estinet.gFeatures.Feature.GenesisEconomy.MoneyManager;
import net.estinet.gFeatures.Feature.gMusic.Music;

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
 										m.sendMusic(p, "theme", 1000, "Vexento", "Movements", "");
 										respawn.respawn(p);
 									}
 								}
 							}
 							
 							Bukkit.getWorld("CTF").spawn(Basic.blueflag, EnderCrystal.class);
 							Bukkit.getWorld("CTF").spawn(Basic.orangeflag, EnderCrystal.class);
 							
 							Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
 					        	public void run(){
 					        		for(Player p : Bukkit.getServer().getOnlinePlayers()){
 					        			Music m = new Music();
 										m.sendMusic(p, "theme", 1000, "Vexento", "Movements", "");
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
 						}
 						else{
 							Basic.countdown = 60;
 							Bukkit.getScheduler().cancelTask(tasknum);
 						}
 					}
 					else{
 					loop.goThrough();
              		for(Player p : Bukkit.getServer().getOnlinePlayers()){
              			p.setScoreboard(l.Initialize(p));
              			p.setLevel(Basic.countdown);
              			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 50, 50);
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
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (UserDoesNotExistException e) {
						e.printStackTrace();
					}
				}
			});
			thr.start();
		}
		Basic.mode = Mode.ENDED;
		if(Basic.orangeflags > Basic.blueflags){
			Action.sendAllTitle(ChatColor.GOLD + "The orange team won!", ChatColor.BOLD + Integer.toString(Basic.orangeflags) + " captured.", 20, 40, 20);
		}
		else if(Basic.orangeflags < Basic.blueflags){
			Action.sendAllTitle(ChatColor.DARK_AQUA + "The blue team won!", ChatColor.BOLD + Integer.toString(Basic.blueflags) + " captured.", 20, 40, 20);
		}
		else{
			Action.sendAllTitle(ChatColor.BOLD + "Both teams tied!", "", 20, 40, 20);
		}
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
	        		recursive();
	        		}
	        	}
	        }, 200L);
	}
}
