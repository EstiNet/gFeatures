package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;

public class WaitingProcess {
	public static void playerJoin(PlayerJoinEvent event){
		if(FusionPlay.currentGame.getSettings().usesSpawns()){
			int counter = 0;
			for(Player p : Bukkit.getOnlinePlayers()){
				p.teleport(FusionPlay.currentGame.getFusionMap().getSpawns().get(counter));
				if(counter == FusionPlay.currentGame.getFusionMap().getSpawns().size() - 2){
					counter = 0;
				}
				else{
					counter++;
				}
			}
		}
		if(FusionPlay.currentGame.getSettings().usesWaitingCounter()){
			CounterProcess.waitInit();
		}
	}
	public static void counterComplete(){
		CliotePing cp = new CliotePing();
		cp.sendMessage("fusionplay started", "Bungee");
		FusionPlay.currentGame.setFusionState(FusionState.STARTED);
		FusionPlay.currentGame.waitTimerComplete();
		CounterProcess.ingameInit(FusionPlay.currentGame.getSettings().getTimeManager());
	}
}
