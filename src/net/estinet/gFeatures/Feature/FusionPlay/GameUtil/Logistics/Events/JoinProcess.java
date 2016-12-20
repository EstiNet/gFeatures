package net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;

import net.estinet.gFeatures.API.Messaging.ActionAPI;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.SpectateProcess;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.Logistics.WaitingProcess;
import net.md_5.bungee.api.ChatColor;

public class JoinProcess {
	public static void init(PlayerJoinEvent event){
		if(FusionPlay.currentGame.getFusionState().equals(FusionState.WAITING)){
			if(FusionPlay.currentGame.getSettings().usesSpawns()){
				WaitingProcess.joinOnWait(event.getPlayer());
			}
			event.getPlayer().setGameMode(FusionPlay.currentGame.defaultGameMode);
			if(Bukkit.getServer().getOnlinePlayers().size() > 1){
				WaitingProcess.playerJoin(event);
			}
			else{
				ActionAPI aapi = new ActionAPI();
				aapi.sendTitle(event.getPlayer(), 10, 20, 10, ChatColor.DARK_GRAY + "Waiting for more players...");
			}
		}
		else{
			SpectateProcess.addSpectator(event.getPlayer());
		}
	}
}
