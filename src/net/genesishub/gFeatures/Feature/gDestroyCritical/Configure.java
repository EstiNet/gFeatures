package net.genesishub.gFeatures.Feature.gDestroyCritical;

import net.genesishub.gFeatures.Basic;

public class Configure {
	public void onSetup(){
		gDestroyCritical base = new gDestroyCritical("gDestroyCritical", 1.0);
		Basic.addFeature(base);
	}
}
