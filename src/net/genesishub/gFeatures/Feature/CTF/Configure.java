package net.genesishub.gFeatures.Feature.CTF;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		CTF ctf = new CTF("CTF", 1.0);
		Basic.addFeature(ctf);
	}
}
