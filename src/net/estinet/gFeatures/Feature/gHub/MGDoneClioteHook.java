package net.estinet.gFeatures.Feature.gHub;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;

public class MGDoneClioteHook extends ClioteHook{

	public MGDoneClioteHook(gFeature feature) {
		super(feature, "mgdone");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			Basis.recieving = false;
			Basis.servers = Basis.assemble;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
