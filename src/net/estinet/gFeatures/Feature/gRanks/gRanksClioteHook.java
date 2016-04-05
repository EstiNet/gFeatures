package net.estinet.gFeatures.Feature.gRanks;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.gRanks.Perms.Cleanup;

public class gRanksClioteHook extends ClioteHook{

	public gRanksClioteHook(gFeature feature) {
		super(feature, "granks");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		if(args.get(0).equals("sync")){
			Thread th = new Thread(new Cleanup());
			th.start();
		}
	}
}
