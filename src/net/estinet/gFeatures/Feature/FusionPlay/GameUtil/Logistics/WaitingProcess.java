package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;
import net.md_5.bungee.api.ChatColor;

public class WaitingProcess {
	private static int counter = 0;
	public static void playerJoin(PlayerJoinEvent event){
		FusionPlay.currentGame.enoughPlayers();
		CounterProcess.waitInit();
	}
	public static void counterComplete(){
		CliotePing cp = new CliotePing();
		cp.sendMessage("fusionplay started", "Bungee");
		FusionPlay.currentGame.setFusionState(FusionState.STARTED);
		FusionPlay.currentGame.waitTimerComplete();
		ActionAPI aapi = new ActionAPI();
		for(Player p : Bukkit.getOnlinePlayers()){
			aapi.sendAll(p, 30, 60, 30, FusionPlay.currentGame.getSettings().getCoolGameName(), ChatColor.BOLD + "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ Game Start! (⌐■_■)", ChatColor.AQUA + "(╯°□°）╯︵ ┻━┻", "woo", "yey");
		}
		TimeManager tm = FusionPlay.currentGame.getSettings().getTimeManager();
		int sec = (int) tm.getLength();
		if(tm.getTimeUnit().equals(TimeUnit.MINUTES)){
			sec *= 60;
		}
		FusionPlay.currentGame.getSettings().secLeft = sec;
		CounterProcess.ingameInit();
	}
	public static void joinOnWait(Player p){
		p.teleport(FusionPlay.currentGame.getFusionMap().getSpawns().get(counter));
		if(counter == FusionPlay.currentGame.getFusionMap().getSpawns().size() - 2){
			counter = 0;
		}
		else{
			counter++;
		}
	}
}
