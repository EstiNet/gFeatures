package net.genesishub.gFeatures.Feature.HideAndSeek;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		HideAndSeek base = new HideAndSeek("HideAndSeek", "1.0.0");
		Basic.addFeature(base);
	}
}
