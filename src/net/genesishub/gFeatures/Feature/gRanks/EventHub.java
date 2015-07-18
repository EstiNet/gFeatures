package net.genesishub.gFeatures.Feature.gRanks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		Player p = event.getPlayer();
        		sqlc.Connect(sqlc.toURL(r.getPort(), r.getAddress(), r.getTablename()), r.getUsername(), r.getPassword(), "INSERT INTO People(UUID, Rank)\n"+
				"SELECT * FROM (SELECT '" + event.getPlayer().getUniqueId().toString() + "', 'Default') AS tmp\n"+
				"WHERE NOT EXISTS (\n"+
				"SELECT UUID FROM People WHERE UUID = '" + event.getPlayer().getUniqueId().toString() + "'\n"+
				") LIMIT 1;\n"
        				);
        		if(!Basis.hasRank(p)){
        			r.setRank(Basis.getRank("Default"), p);
        		}
        	}
        }, 40L);
		PermissionAttachment pa = event.getPlayer().addAttachment(Bukkit.getPluginManager().getPlugin("gFeatures"));
		for(String perm : Basis.getRank(r.getRank(event.getPlayer())).getPerms()){
			boolean isittrue;
			if(perm.contains("-")){
				isittrue = false;
				perm = perm.replace("-", "");
			}
			else{
				isittrue = true;
			}
			Bukkit.getLogger().info("Perm: " + perm + " is it true: " + Boolean.toString(isittrue));
			pa.setPermission(perm, isittrue);
		}
		Basis.addPermissionAttach(event.getPlayer().getUniqueId(), pa);
	}
	public void onPlayerChat(AsyncPlayerChatEvent event){
		try{
		String prefix = Basis.getRank(r.getRank(event.getPlayer())).getPrefix();
		String name = prefix.replace('&', '§');
		event.getPlayer().setDisplayName(name + event.getPlayer().getDisplayName());
		}
		catch(Exception e){
			Basis.getRank("Default").addPerson(event.getPlayer().getUniqueId().toString());
		}
	}
	public void onPlayerLeave(PlayerQuitEvent event){
		Basis.removePermissionsAttach(event.getPlayer().getUniqueId());
	}
}
