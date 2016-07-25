package net.estinet.gFeatures.Feature.ServerQuery;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;

public class ServerQueryClioteHook extends ClioteHook{

	public ServerQueryClioteHook(gFeature feature) {
		super(feature, "info");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		if(args.get(0).equals("online")){
			ServerQuery.setPlayerCount(Integer.parseInt(args.get(1)));
		}
		else if(args.get(0).equals("playerget")){
			Execute e = ServerQuery.hash.get(args.get(1));
			e.server = args.get(1);
			
		}
	}
}
