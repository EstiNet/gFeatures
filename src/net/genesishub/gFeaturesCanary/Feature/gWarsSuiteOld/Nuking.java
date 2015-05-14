package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

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

public class Nuking{
	TeamManager tm = new TeamManager();
	Constants cons = new Constants();
	public void NukeInitiate(final CommandSender sender, Command cmd, String label, String[] args, Player s){
		int x = (int) s.getLocation().getX();
		int z = (int) s.getLocation().getZ();
		if((!Constants.spectate.contains(s.getName()))){
		try{
	if(x == 569 && z == 419 || x == 569 && z == 420 || x == 569 && z == 418){
		if(Constants.boots == true){
		sender.sendMessage("Nuking selection activated.");
         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "speed fly 10 "+ sender.getName());
         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp "+ sender.getName() + " 487 36 178");
		sender.sendMessage("Welcome to the missle control pad!");
		sender.sendMessage("Fly to the area you want to launch the missle to.");
		sender.sendMessage("Then, do /done!");
		sender.sendMessage("You have 1 minute, or you will instantly be killed!");
		sender.sendMessage("Good luck!");
		Constants.playernukename = s.getName();
		s.setGameMode(GameMode.SPECTATOR);
		Constants.boot = true;
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		if (Constants.boot==true){
           sender.sendMessage("You took too long!");
           ((Player) sender).showPlayer((Player)sender);
        	((Player)sender).setGameMode(GameMode.SURVIVAL);
    		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp "+ sender.getName() + " 569 2 419");}
           }
        }, 720L);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
           Bukkit.getServer().broadcastMessage("Nuke is ready to launch!");
          Constants.boots = true;
    		}
        }, 12000L);
		}
		else{
			sender.sendMessage("The nuke isn't ready for launch yet! Wait for the announcement in the chat when the nuke is ready!");
		}
		}
		else{
			sender.sendMessage("Nope.");
		}
		}
		catch(Exception e){
			Bukkit.getServer().getLogger().info("UHOH");
		}
		}
		else{
			sender.sendMessage("You are spectating. Stop cheating.");
		}
	}
	@SuppressWarnings("deprecation")
	public void AntiNukeInitiate(final CommandSender sender, Command cmd, String label, String[] args, Player s){
		List<Entity> nearby = ((Player)sender).getNearbyEntities(30, 30, 30);
		ArrayList<Player> nearbyPlayers = new ArrayList<Player>();
		for (Entity entity : nearby) {
		    if (entity instanceof Player) {
		         nearbyPlayers.add((Player) entity);
		    }
		}
		for (Player killhim : nearbyPlayers){
			if(!(Constants.arena.contains(killhim))&& Constants.spectate.contains(s.getName())){
				sender.sendMessage("You can't fire a nuke at someone at spawn!");
				s.setGameMode(GameMode.SURVIVAL);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "speed fly 1 "+ sender.getName());
    			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp "+ sender.getName() + " 569 2 419");
			}
		}
		Location nukeplace = s.getLocation();
		if(s.getName() == Constants.playernukename){
		sender.sendMessage("Launching missle...");
		Bukkit.getServer().broadcastMessage("A nuke has been fired by " + s.getName() + " at the location " + (int)nukeplace.getX() + " " + (int)nukeplace.getY() + " " + (int)nukeplace.getZ());
		Player[] all = Bukkit.getServer().getOnlinePlayers();
		for(Player sound : all){
			sound.playSound(sound.getLocation(), Sound.AMBIENCE_THUNDER, 3, 0);
		}
		for (Player killhim : nearbyPlayers){
			if(!(Constants.spectate.contains(killhim))){
			killhim.setHealth(0);
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY+"Player " + killhim.getName() + " from the " + tm.getTeam(killhim.getName()) + ChatColor.GRAY+" team has been obliberated by the nuke!");
			}
		}
		sender.sendMessage("Your nuke killed " + nearbyPlayers.size() + " people.");
		Constants.playernukename = "";
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "speed fly 1 "+ sender.getName());
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp "+ sender.getName() + " 569 2 419");
		s.setGameMode(GameMode.SURVIVAL);
		Constants.boot = false;
		Constants.boots = false;
		}
		else{
			sender.sendMessage("Nope.");
		}
	}
}
