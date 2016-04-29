package net.estinet.gFeatures.Feature.gHub;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;

public class MGStartClioteHook extends ClioteHook{

	public MGStartClioteHook(gFeature feature) {
		super(feature, "mgstart");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			Basis.recieving = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
