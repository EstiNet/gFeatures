package net.genesishub.gFeatures.Feature.Base;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure{
	ConfigHub ch = new ConfigHub();
	@Configs
	public void onSetup(){
		Base base = new Base("Base", 1.0);
		Basic.addFeature(base);
		ch.setupConfig();
	}
}
