package tk.genesishub.gFeatures.gWarsSuite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

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

public class ListTeams{
	Constants cons = new Constants();
	StatsRetrieve sr = new StatsRetrieve();
	public void TeamListInitiate(final CommandSender sender, Command cmd, String label, String[] args){
	doorange((Player)sender);
	BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    scheduler.scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
    	public void run(){
       doblue((Player)sender);
       }
    }, 6L);
    }
	public void doorange(Player sender){
		try{
		orangelist((Player) sender);
		}
		catch(Exception e){
			Bukkit.getServer().getLogger().info("UHOH");
		}
	}
	public void doblue(Player sender){
		try{
		bluelist((Player) sender);
		}
		catch(Exception e){
			Bukkit.getServer().getLogger().info("UHOH");
		}
	}
	public void orangelist(Player sender){
		sender.sendMessage(ChatColor.GOLD+"Orange Team Members:");
		sender.sendMessage("There are " + Constants.ot.size() + " players on this team.");
		for(int iter = 0; iter <= Constants.ot.size(); iter++){
			sender.sendMessage(Constants.ot.get(iter) + " with " + sr.getKills(Constants.ot.get(iter)) + " kills");
		}
		return;
	}
	public void bluelist(Player sender){
		sender.sendMessage(ChatColor.DARK_AQUA+"Blue Team Members:");
		sender.sendMessage("There are " + Constants.bt.size() + " players on this team.");
		for(int iter = 0; iter <= Constants.bt.size(); iter++){
			sender.sendMessage(Constants.bt.get(iter) + " with " + sr.getKills(Constants.bt.get(iter)) + " kills");
		}
		return;
	}	
}
