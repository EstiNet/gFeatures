package net.estinet.gFeatures.Feature.gRanks;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.gRanks.Events.StartupTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;

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

public class EventHub{
	Retrieve r = new Retrieve();
	SQLConnect sqlc = new SQLConnect();
	public void onPlayerJoin(PlayerJoinEvent event){
		try{
			Thread thr = new Thread(new Runnable(){
				public void run(){
					StartupTask st = new StartupTask();
					st.init(event);
				}
			});
			thr.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void onPlayerChat(AsyncPlayerChatEvent event){
		try{
			String prefix = Basis.getRank(r.getRank(event.getPlayer())).getPrefix();
			String name = prefix.replace('&', '§');
			if(!event.getPlayer().getDisplayName().contains(name)){
				event.getPlayer().setDisplayName(name + event.getPlayer().getName());
			}
		}
		catch(Exception e){
			Basis.getRank("Default").addPerson(event.getPlayer().getUniqueId().toString());
		}
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		try{
			Basis.removePermissionsAttach(event.getPlayer().getUniqueId());
		}
		catch(Throwable e){
			e.printStackTrace();
		}
	}
}
