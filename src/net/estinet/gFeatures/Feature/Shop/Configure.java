package net.estinet.gFeatures.Feature.Shop;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.Command.EstiCommand;
public class Configure{
	@Configs
	public static void onSetup(){
		Shop base = new Shop("Shop", "1.0.0");
		Basic.addFeature(base);
		
		EstiCommand test = new EstiCommand("cosmetics", "Shows cosmetics menu.", "/cosmetics", base, true);
		Basic.addCommand(test);
	}
}
