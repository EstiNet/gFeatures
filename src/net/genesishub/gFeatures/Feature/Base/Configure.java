package net.genesishub.gFeatures.Feature.Base;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Setup;
import net.genesishub.gFeatures.gFeature;

public class Configure extends Setup{
	@Override
	public void onSetup(){
		gFeature feature = new gFeature("Base", 1.0);
		Basic.addFeature(feature);
	}
}
