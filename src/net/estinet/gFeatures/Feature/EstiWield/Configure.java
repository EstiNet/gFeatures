package net.estinet.gFeatures.Feature.EstiWield;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;

public class Configure{
	@Configs
	public static void onSetup(){
		EstiWield base = new EstiWield("EstiWield", "1.0.0b");
		Basic.addFeature(base);
	}
}
