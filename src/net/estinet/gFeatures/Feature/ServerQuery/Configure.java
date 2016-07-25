package net.estinet.gFeatures.Feature.ServerQuery;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
public class Configure{
	@Configs
	public static void onSetup(){
		Base base = new Base("Base", "1.2.5");
		Basic.addFeature(base);
	}
}
