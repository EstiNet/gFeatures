package net.genesishub.gFeatures.Feature.GenesisAccess;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	ConfigHub ch = new ConfigHub();
	@Configs
	public void onSetup(){
		GenesisAccess genesisaccess = new GenesisAccess("GenesisAccess", 1.3);
		Basic.addFeature(genesisaccess);
		ch.setupConfig();
	}
}
