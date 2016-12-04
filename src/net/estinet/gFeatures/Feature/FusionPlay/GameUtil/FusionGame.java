package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.Feature.FusionPlay.Disable;
import net.estinet.gFeatures.Feature.FusionPlay.Enable;

public class FusionGame extends gFeature{
	public FusionGame(String featurename, String version) {
		super(featurename, version);
	}
	@Override
	public void enable(){
		Enable.onEnable();
	}
	@Override
	public void disable(){
		Disable.onDisable();
	}
}
