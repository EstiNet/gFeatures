package net.estinet.gFeatures.Feature.CTF;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;

public class Configure{
	@Configs
	public static void onSetup(){
		CTF base = new CTF("CTF", "1.0.2");
		Basic.addFeature(base);
	}
}
