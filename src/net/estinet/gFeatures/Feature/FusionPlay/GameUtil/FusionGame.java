package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import net.estinet.gFeatures.gFeature;

public class FusionGame {
	private gFeature feature;
	public FusionGame(gFeature feature){
		this.feature = feature;
	}
	public String getName(){
		return feature.getName();
	}
	public gFeature getFeature(){
		return feature;
	}
}
