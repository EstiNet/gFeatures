package tk.genesishub.gFeatures.gFactions;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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
	JoinManager jm = new JoinManager();
	PreventAutoClaim pac = new PreventAutoClaim();
	public void onEnable(){
		Bukkit.getLogger().info("gFactions initialized! Yay!");
	}
	public void onDisable(){
		Bukkit.getLogger().info("gFactions is now off! :(");
	}
	public void onPlayerJoin(PlayerJoinEvent event){
		//jm.Initialize(event);
	}
	public void onCommandPre(PlayerCommandPreprocessEvent event){
		if(Const.atSpawn.contains(event.getPlayer())){
			
		}
	}
	public void PlayerEnterRegionEvent(RegionEnterEvent event){
		Const.atSpawn.add(event.getPlayer().getName());
		//pac.Initialize(event);
	}
	public void PlayerLeaveRegionEvent(RegionLeaveEvent event){
		Const.atSpawn.remove(event.getPlayer().getName());
	}
}
