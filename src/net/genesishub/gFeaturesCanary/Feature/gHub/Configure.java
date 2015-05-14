package net.genesishub.gFeatures.Feature.gHub;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		gHub base = new gHub("gHub", "1.0.0");
		Basic.addFeature(base);
	}
}
