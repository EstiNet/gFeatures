package net.estinet.gFeatures.Feature.FusionPlay;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Command.EstiCommand;
import net.estinet.gFeatures.Feature.Base.Commands.TestCommand;
public class Configure{
	@Configs
	public static void onSetup(){
		FusionPlay base = new FusionPlay("FusionPlay", "1.0.0");
		Basic.addFeature(base);
		
		FusionPlayClioteHook fpch = new FusionPlayClioteHook(base);
		ClioteSky.addClioteHook(fpch);
	}
}
