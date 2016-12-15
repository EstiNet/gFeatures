package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;
import net.md_5.bungee.api.ChatColor;

public class CounterProcess {
	public static void waitInit(){
		FusionPlay.currentGame.enoughPlayers();
		Thread thr = new Thread(new Runnable(){
			public void run(){
				if(FusionPlay.currentGame.getSettings().getWaitingSecLeft() <= 0){
					WaitingProcess.counterComplete();
				}
				else{
					if(Bukkit.getOnlinePlayers().size() < 2){
						FusionPlay.currentGame.getSettings().waitingSecLeft = FusionPlay.currentGame.getSettings().getDefaultWaitingSecLeft();
						for(Player p : Bukkit.getOnlinePlayers()){
							ActionAPI api = new ActionAPI();
							api.sendTitle(p, 1, 1, 1, ChatColor.AQUA + "Not enough players! .-.");
						}
					}
					else{
						for(Player p : Bukkit.getOnlinePlayers()){
							ActionAPI aapi = new ActionAPI();
							aapi.sendTitles(p, 1, 1, 1, FusionPlay.currentGame.getSettings().getCoolGameName(), ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "⚠" + ChatColor.GOLD + "" + ChatColor.BOLD + "] " + ChatColor.WHITE + ChatColor.BOLD + FusionPlay.currentGame.getSettings().getWaitingSecLeft() + ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "⚠" + ChatColor.GOLD + "" + ChatColor.BOLD + "] ");
						}
						FusionPlay.currentGame.getSettings().setWaitingSecLeft(FusionPlay.currentGame.getSettings().getWaitingSecLeft()-1);
						run();
					}
				}
			}
		});
		thr.start();
	}
	public static void ingameInit(TimeManager tm){
		int sec = (int) tm.getLength();
		if(tm.getTimeUnit().equals(TimeUnit.MINUTES)){
			sec *= 60;
		}
		
	}
}
