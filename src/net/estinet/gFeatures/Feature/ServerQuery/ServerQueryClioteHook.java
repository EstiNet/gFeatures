package net.estinet.gFeatures.Feature.ServerQuery;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.FeatureState;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.gScore.Listeners;

public class ServerQueryClioteHook extends ClioteHook{

	public ServerQueryClioteHook(gFeature feature) {
		super(feature, "info");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		if(args.get(0).equals("online")){
			ServerQuery.setPlayerCount(Integer.parseInt(args.get(1)));
			if(Basic.getFeature("gScore").getState().equals(FeatureState.ENABLE)){
				Listeners l = new Listeners();
				for(Player p : Bukkit.getOnlinePlayers()){
					l.set(p);
				}
			}
		}
		else if(args.get(0).equals("playerget")){
			Execute e = ServerQuery.hash.get(args.get(1));
			e.server = args.get(2);
			e.run();
		}
	}
}
