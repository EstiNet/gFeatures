package net.estinet.gFeatures.ClioteSky.Network.Protocol.Input;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.FeatureState;
import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;

public class InputMessage extends Packet{
	public InputMessage(){
		super.name = "Message";
	}
	public void run(List<String> args){
		List<String> newArgs = new ArrayList<>();
		for(int i = 3; i < args.size(); i++){
			newArgs.add(args.get(i));
		}
		Debug.print("Recieved message " + args + " from category " + args.get(0) + " and cliote " + args.get(1));
		for(ClioteHook ch : ClioteSky.hooks){
			if(ch.getCoreArgument().equals(args.get(2)) && Basic.getFeature(ch.getgFeature().getName()).getState().equals(FeatureState.ENABLE)){
				ch.run(newArgs, args.get(0), args.get(1));
			}
		}
	}
}