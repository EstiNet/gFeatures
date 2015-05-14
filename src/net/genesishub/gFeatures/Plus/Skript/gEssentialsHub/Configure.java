package net.genesishub.gFeatures.Plus.Skript.gEssentialsHub;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;
import net.genesishub.gFeatures.Extension;

public class Configure {
	@Configs
	public static void onSetup(){
		Extension gCrates = new Extension("gEssentialsHub", "1.0.0");
		Basic.addExtension(gCrates);
	}
}
