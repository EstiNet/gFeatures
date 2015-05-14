package net.genesishub.gFeatures.Feature.gMusic;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		gMusic base = new gMusic("gMusic", "1.0.0");
		Basic.addFeature(base);
	}
}
