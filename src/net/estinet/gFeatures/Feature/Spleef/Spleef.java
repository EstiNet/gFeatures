package net.estinet.gFeatures.Feature.Spleef;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import net.estinet.gFeatures.Events;
import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionGame;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.SpectateProcess;
import net.estinet.gFeatures.Feature.ParkourRace.Logistics.ScoreboardCreator;
import net.md_5.bungee.api.ChatColor;

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

public class Spleef extends FusionGame implements Events{
	
	EventHub eh = new EventHub();
	
	public static List<UUID> stillIn = new ArrayList<>();
	public static Stack<UUID> howFar = new Stack<>();
	
	public Spleef(String featurename, String version) {
		super(featurename, version);
	}
	@Override
	public void enable(){
		net.estinet.gFeatures.Feature.Spleef.Enable.onEnable();
	}
	@Override
	public void disable(){
		Disable.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("blockbreakevent")){
			eh.onPlayerBreak((BlockBreakEvent)event);
		}
	}
	@Override
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	@Retrieval
	public void onPlayerBreakBlock(){}
	@Override
	public void waitTimerComplete(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		for(Player p : Bukkit.getOnlinePlayers()){
        			if(p.getLocation().getY() < 26 && !SpectateProcess.spectators.contains(p.getUniqueId())){
        				SpectateProcess.addSpectator(p);
        				p.teleport(SMap.spectate);
        				Spleef.howFar.push(p.getUniqueId());
        				Spleef.stillIn.remove(p.getUniqueId());
        				if(Spleef.stillIn.size() < 2){
        					FusionPlay.currentGame.finishGame(false);
        				}
        			}
        		}
        	}
        }, 10L, 10L);
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().addItem(new ItemStack(Material.DIAMOND_SPADE));
		}
	}
	@Override
	public void timerOneSec(int seconds){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setScoreboard(ScoreboardCreator.getScoreboard(seconds));
		}
	}
	@Override
	public void gameEnd(boolean usedTimer){
		if(!(stillIn.size() == 0)){
			for(int i = 0; i < stillIn.size();){
				howFar.push(stillIn.get(0));
				stillIn.remove(0);
			}
		}
		Player name1 = null , name2 = null, name3;
		try{
			name1 = Bukkit.getPlayer(howFar.pop());
			name2 = Bukkit.getPlayer(howFar.pop());
			name3 = Bukkit.getPlayer(howFar.pop());
		}
		catch(Exception e){
			name3 = name2;
		}
		int num = 4;
		while(howFar.size() > 0){
			UUID uuid = howFar.pop();
			Bukkit.getPlayer(uuid).sendMessage(ChatColor.AQUA + "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧  You were " + num + "th!");
			num++;
		}
		name1.sendMessage(ChatColor.AQUA + "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧  You were 1st!");
		name2.sendMessage(ChatColor.AQUA + "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧  You were 2nd!");
		name3.sendMessage(ChatColor.AQUA + "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧  You were 3rd!");
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
			try{
				FusionPlay.winners(name1, name2, name3);
			}
			catch(Exception e){
				FusionPlay.winners(name1, name2, name3);
			}
		}
	}
}
