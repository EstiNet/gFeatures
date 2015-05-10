package net.genesishub.gFeatures.Feature.GenesisBackup;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		GenesisBackup base = new GenesisBackup("GenesisBackup", 1.0);
		Basic.addFeature(base);
	}
}
