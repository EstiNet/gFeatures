package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

public class EnabledHandler {
	public static void init(){
		CliotePing cp = new CliotePing();
		FusionPlay.currentGame.setFusionState(FusionState.WAITING);
		if(FusionPlay.otherup){
			cp.sendMessage("fusionplay otherup " + FusionPlay.currentGame.getName(), "Bungee");
		}
		else{
			cp.sendMessage("fusionplay online " + FusionPlay.currentGame.getName(), "Bungee");
		}
	}
}
