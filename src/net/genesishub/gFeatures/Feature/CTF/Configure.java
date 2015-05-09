package net.genesishub.gFeatures.Feature.CTF;

import net.genesishub.gFeatures.Basic;

public class Configure {
	public void onSetup(){
		CTF ctf = new CTF("CTF", 1.0);
		Basic.addFeature(ctf);
	}
}
