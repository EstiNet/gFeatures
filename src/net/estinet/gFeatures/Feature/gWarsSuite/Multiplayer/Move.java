package net.estinet.gFeatures.Feature.gWarsSuite.Multiplayer;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.gWarsSuite.Constants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

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

public class Move {
	ActionAPI aapi = new ActionAPI();
	Source s = new Source();
	public void initialize(PlayerMoveEvent event){
		if(!Constants.capturetrigger.contains(event.getPlayer().getName())){
		for(Point point : Constants.multiplayerpossession.keySet()){
			if(point.isInLocation(event.getPlayer().getLocation())){
				if(OrangeTeam.hasPlayer(event.getPlayer())){
					if(point.getCaptureState().equals(CaptureState.blue) || point.getCaptureState().equals(CaptureState.white)){
						point.setNeutral();
						s.flushAll();
						Constants.capturetrigger.add(event.getPlayer().getName());
						for(Player p : Bukkit.getOnlinePlayers()){
							aapi.sendTitles(p, 20, 40, 20, ChatColor.GOLD + point.getName() + " is being captured!", ChatColor.GOLD + point.getName() + " is now " + ChatColor.WHITE + ChatColor.BOLD + " NEUTRAL.");
						}
						Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
				        	public void run(){
				        		Constants.capturetrigger.remove(event.getPlayer().getName());
				        		if(point.isInLocation(event.getPlayer().getLocation())){
				        			point.setOrange();
				        			Constants.multiplayerpossession.remove(point);
				        			Constants.multiplayerpossession.put(point, Team.ORANGE);
									s.flushAll();
									for(Player p : Bukkit.getOnlinePlayers()){
										aapi.sendTitles(p, 20, 40, 20, ChatColor.GOLD + point.getName() + " has been captured by Kloyne!", ChatColor.GOLD + point.getName() + " is now ORANGE.");
									}
									
				        		}
				        	}
				        }, 60L);
					}
				}
				else if(BlueTeam.hasPlayer(event.getPlayer())){
					if(point.getCaptureState().equals(CaptureState.orange) || point.getCaptureState().equals(CaptureState.white)){
						point.setNeutral();
						s.flushAll();
						Constants.capturetrigger.add(event.getPlayer().getName());
						for(Player p : Bukkit.getOnlinePlayers()){
							aapi.sendTitles(p, 20, 40, 20, ChatColor.DARK_AQUA + point.getName() + " is being captured!", ChatColor.DARK_AQUA + point.getName() + " is now " + ChatColor.WHITE + ChatColor.BOLD + " NEUTRAL.");
						}
						Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
				        	public void run(){
				        		Constants.capturetrigger.remove(event.getPlayer().getName());
				        		if(point.isInLocation(event.getPlayer().getLocation())){
				        			point.setBlue();
				        			Constants.multiplayerpossession.remove(point);
				        			Constants.multiplayerpossession.put(point, Team.BLUE);
									s.flushAll();
									for(Player p : Bukkit.getOnlinePlayers()){
										aapi.sendTitles(p, 20, 40, 20, ChatColor.DARK_AQUA + point.getName() + " has been captured by Innisfil!", ChatColor.DARK_AQUA + point.getName() + " is now BLUE.");
									}
				        		}
				        	}
				        }, 60L);
					}
				}
			}
		}	
	}
	}
}
