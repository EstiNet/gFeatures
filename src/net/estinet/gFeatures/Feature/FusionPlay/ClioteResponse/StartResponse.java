package net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse;

import java.util.List;

import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

public class StartResponse {
	public static void response(List<String> args, String categoryName, String clioteName){
		FusionPlay.assigned = true;
		FusionPlay.currentGame.gameAssigned();
	}
}
