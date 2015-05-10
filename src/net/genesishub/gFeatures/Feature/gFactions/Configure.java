package net.genesishub.gFeatures.Feature.gFactions;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		gFactions base = new gFactions("gFactions", 1.0);
		Basic.addFeature(base);
	}
}
