package net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse;

import java.util.List;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionState;

public class StartResponse {
	public static void response(List<String> args, String categoryName, String clioteName){
		CliotePing cp = new CliotePing();
		if(!FusionPlay.otherup){
			cp.sendMessage("fusionplay cachealive", "Bungee");
		}
		FusionPlay.assigned = true;
		FusionPlay.currentGame.gameAssigned();
		FusionPlay.currentGame.setFusionState(FusionState.WAITING);
	}
}
