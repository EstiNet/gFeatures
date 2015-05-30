package net.genesishub.gFeatures.Feature.Statistics;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		Statistics base = new Statistics("Statistics", "1.0.2");
		Basic.addFeature(base);
	}
}
