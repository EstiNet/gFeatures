package net.genesishub.gFeatures.Feature.GenesisAccess;

import net.genesishub.gFeatures.Basic;

public class Configure {
	ConfigHub ch = new ConfigHub();
	public void onSetup(){
		GenesisAccess genesisaccess = new GenesisAccess("GenesisAccess", 1.3);
		Basic.addFeature(genesisaccess);
		ch.setupConfig();
	}
}
