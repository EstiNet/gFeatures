package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.WaitingProcess;

public class JoinProcess {
	public static void init(PlayerJoinEvent event){
		if(FusionPlay.currentGame.getFusionState().equals(FusionState.WAITING)){
			if(Bukkit.getServer().getOnlinePlayers().size() > 1){
				WaitingProcess.playerJoin(event);
			}
		}
	}
}
