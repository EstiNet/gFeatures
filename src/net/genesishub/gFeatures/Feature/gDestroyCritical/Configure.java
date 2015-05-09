package net.genesishub.gFeatures.Feature.gDestroyCritical;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Feature.Base.Base;
import net.genesishub.gFeatures.Feature.Base.ConfigHub;

public class Configure {
	ConfigHub ch = new ConfigHub();
	public void onSetup(){
		Base base = new Base("Base", 1.0);
		Basic.addFeature(base);
		ch.setupConfig();
	}
}
