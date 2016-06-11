package net.estinet.gFeatures.Feature.Friendship;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.Command.EstiCommand;
import net.estinet.gFeatures.Feature.Base.Commands.TestCommand;
public class Configure{
	@Configs
	public static void onSetup(){
		Friendship base = new Friendship("Friendship", "1.0.0");
		Basic.addFeature(base);
		
		EstiCommand test = new EstiCommand("test", "Says test!", "/test", "gFeatures.test", base, new TestCommand());
		Basic.addCommand(test);
	}
}
