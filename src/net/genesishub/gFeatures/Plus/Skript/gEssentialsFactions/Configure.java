package net.genesishub.gFeatures.Plus.Skript.gEssentialsFactions;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;
import net.genesishub.gFeatures.Extension;

public class Configure {
	@Configs
	public static void onSetup(){
		Extension gCrates = new Extension("gEssentialsFactions", "1.0.0");
		Basic.addExtension(gCrates);
	}
}
