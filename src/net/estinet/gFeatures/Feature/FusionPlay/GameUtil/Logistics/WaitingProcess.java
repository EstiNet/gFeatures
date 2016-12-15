package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;

public class WaitingProcess {
	private static int counter = 0;
	public static void playerJoin(PlayerJoinEvent event){
		CounterProcess.waitInit();
	}
	public static void counterComplete(){
		CliotePing cp = new CliotePing();
		cp.sendMessage("fusionplay started", "Bungee");
		FusionPlay.currentGame.setFusionState(FusionState.STARTED);
		FusionPlay.currentGame.waitTimerComplete();
		CounterProcess.ingameInit(FusionPlay.currentGame.getSettings().getTimeManager());
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
