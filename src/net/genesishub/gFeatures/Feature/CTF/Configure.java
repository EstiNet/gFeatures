package net.genesishub.gFeatures.Feature.CTF;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Feature.Base.ConfigHub;

public class Configure {
	ConfigHub ch = new ConfigHub();
	public void onSetup(){
		CTF ctf = new CTF("CTF", 1.0);
		Basic.addFeature(ctf);
		ch.setupConfig();
	}
}
