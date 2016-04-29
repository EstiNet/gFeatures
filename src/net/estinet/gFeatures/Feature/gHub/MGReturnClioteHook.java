package net.estinet.gFeatures.Feature.gHub;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;

public class MGReturnClioteHook extends ClioteHook{

	public MGReturnClioteHook(gFeature feature) {
		super(feature, "mgrecieve");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(Basis.recieving == true){
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
