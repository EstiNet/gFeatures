package net.estinet.gFeatures.Feature.gHub;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.gHub.crystal.MGServerPlus;

public class MGReturnClioteHook extends ClioteHook{

	public MGReturnClioteHook(gFeature feature) {
		super(feature, "mgrecieve");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(Basis.recieving == true){
				MGServerPlus mgsp = new MGServerPlus(args.get(0), args.get(1));
				Basis.assemble.add(mgsp);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
