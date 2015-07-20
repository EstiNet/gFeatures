package net.genesishub.gFeatures.Utility.gMotd;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		gMotd gBroadcast = new gMotd("gMotd", "1.0.0");
		Basic.addExtension(gBroadcast);
	}
}
