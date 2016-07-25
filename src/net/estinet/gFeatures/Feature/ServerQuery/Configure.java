package net.estinet.gFeatures.Feature.ServerQuery;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
public class Configure{
	@Configs
	public static void onSetup(){
		ServerQuery base = new ServerQuery("ServerQuery", "1.0.0");
		Basic.addFeature(base);
	}
}
