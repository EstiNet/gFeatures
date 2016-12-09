package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;

public class WaitingProcess {
	public static void playerJoin(PlayerJoinEvent event){
		//LATER IMPLEMENT IF USESWAITCOUNTER
		if(FusionPlay.currentGame.getSettings()){
			
		}
	}
	public static void counterComplete(){
		CliotePing cp = new CliotePing();
		cp.sendMessage("fusionplay started", "Bungee");
		FusionPlay.currentGame.setFusionState(FusionState.STARTED);
		FusionPlay.currentGame.waitTimerComplete();
		if(FusionPlay.currentGame.getSettings().usesSpawns()){
			//random spawn player move and stuff
		}
	}
}
