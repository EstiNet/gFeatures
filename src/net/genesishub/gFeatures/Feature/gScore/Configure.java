package net.genesishub.gFeatures.Feature.gScore;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		gScore base = new gScore("gScore", 1.0);
		Basic.addFeature(base);
	}
}
