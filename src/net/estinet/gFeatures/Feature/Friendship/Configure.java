package net.estinet.gFeatures.Feature.Friendship;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Command.EstiCommand;
public class Configure{
	@Configs
	public static void onSetup(){
		Friendship base = new Friendship("Friendship", "1.0.0");
		Basic.addFeature(base);
		
		EstiCommand test = new EstiCommand("friends", "Shows the friend menu!", "/friends", base, true);
		Basic.addCommand(test);
		
		FriendDetailsClioteHook mmap = new FriendDetailsClioteHook(base);
		ClioteSky.addClioteHook(mmap);
		FriendGetClioteHook m = new FriendGetClioteHook(base);
		ClioteSky.addClioteHook(m);
		FriendReqClioteHook mm = new FriendReqClioteHook(base);
		ClioteSky.addClioteHook(mm);
	}
}
