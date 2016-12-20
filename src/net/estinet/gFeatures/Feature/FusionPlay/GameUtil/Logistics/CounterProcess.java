package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.CTF.Basic;
import net.estinet.gFeatures.Feature.CTF.Mode;
import net.estinet.gFeatures.Feature.CTF.Holo.CTFScore;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionGame;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;
import net.md_5.bungee.api.ChatColor;

public class CounterProcess {
	public static void waitInit(){

		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				if(FusionPlay.currentGame.getSettings().getWaitingSecLeft() <= 0){
					WaitingProcess.counterComplete();
				}
				else{
					if(Bukkit.getOnlinePlayers().size() < 2){
						FusionPlay.currentGame.getSettings().waitingSecLeft = FusionPlay.currentGame.getSettings().getDefaultWaitingSecLeft();
						for(Player p : Bukkit.getOnlinePlayers()){
							ActionAPI api = new ActionAPI();
							api.sendTitle(p, 20, 40, 20, ChatColor.AQUA + "Not enough players! (；一_一)");
						}
					}
					else{
						for(Player p : Bukkit.getOnlinePlayers()){
							ActionAPI aapi = new ActionAPI();
							aapi.sendTitles(p, 10, 20, 10, FusionPlay.currentGame.getSettings().getCoolGameName(), ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "⚠" + ChatColor.GOLD + "" + ChatColor.BOLD + "] " + ChatColor.WHITE + ChatColor.BOLD + FusionPlay.currentGame.getSettings().getWaitingSecLeft() + ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "⚠" + ChatColor.GOLD + "" + ChatColor.BOLD + "] ");
						}
						FusionPlay.currentGame.getSettings().setWaitingSecLeft(FusionPlay.currentGame.getSettings().getWaitingSecLeft()-1);

						waitInit();
					}
				}
			}
		}, 20L);
	}
	public static void ingameInit(){
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
			public void run(){
				if(!FusionPlay.currentGame.getFusionState().equals(FusionState.ENDED)){
					if(FusionPlay.currentGame.getSettings().secLeft == 0){
						FusionPlay.currentGame.finishGame(true);
					}
					else{
						FusionPlay.currentGame.getSettings().secLeft -= 1;
						FusionPlay.currentGame.timerOneSec(FusionPlay.currentGame.getSettings().secLeft);

						ingameInit();
					}
				}
			}
		}, 20L);
	}
}
