package net.genesishub.gFeatures.Utility.gBroadcast;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;
import net.genesishub.gFeatures.Extension;
import net.genesishub.gFeatures.ExtensionsType;

public class Configure {
	@Configs
	public static void onSetup(){
		Extension gBroadcast = new Extension("gBroadcast", "1.0.0", ExtensionsType.Utility);
		Basic.addExtension(gBroadcast);
	}
}
