package net.genesishub.gFeatures.Feature.gWarsSuite;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;
import net.genesishub.gFeatures.Feature.Base.Base;

public class Configure {
	@Configs
	public static void onSetup(){
		Base base = new Base("gWarsSuite", "3.0.0");
		Basic.addFeature(base);
	}
}
