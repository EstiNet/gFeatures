package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	static ConfigHub ch = new ConfigHub();
	@Configs
	public static void onSetup(){
		gWarsSuite base = new gWarsSuite("gWarsSuite", "3.0.0");
		Basic.addFeature(base);
		ch.setupConfig();
	}
}
