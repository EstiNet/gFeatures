package net.genesishub.gFeatures.Plus.Skript.gMMO;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;
import net.genesishub.gFeatures.Extension;
import net.genesishub.gFeatures.ExtensionsType;

public class Configure {
	@Configs
	public static void onSetup(){
		Extension gCrates = new Extension("gMMO", "1.0.0", ExtensionsType.Skript);
		Basic.addExtension(gCrates);
	}
}
