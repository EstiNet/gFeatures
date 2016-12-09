package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics;

import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

public class WaitingProcess {
	public static void playerJoin(PlayerJoinEvent event){
		if(FusionPlay.currentGame.getSettings()){
			
		}
	}
	public static void counterComplete(){
		CliotePing cp = new CliotePing();
		cp.sendMessage("fusionplay started", "Bungee");
		FusionPlay.currentGame.waitTimerComplete();
	}
}
