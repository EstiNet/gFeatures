package net.genesishub.gFeatures.Feature.Base;

import net.genesishub.gFeatures.Basic;

public class Configure{
	ConfigHub ch = new ConfigHub();
	public void onSetup(){
		Base base = new Base("Base", 1.0);
		Basic.addFeature(base);
		ch.setupConfig();
	}
}
