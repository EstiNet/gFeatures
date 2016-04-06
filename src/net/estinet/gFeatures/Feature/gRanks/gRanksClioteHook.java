package net.estinet.gFeatures.Feature.gRanks;

import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.gRanks.Perms.Cleanup;

public class gRanksClioteHook extends ClioteHook{

	public gRanksClioteHook(gFeature feature) {
		super(feature, "granks");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		if(args.get(0).equals("sync")){
			try{
				Bukkit.getLogger().info("[gRanks] Syncing permissions database...");
				Thread th = new Thread(new Cleanup());
				th.start();
				Basis b = new Basis();
				b.initializeQuery();
			}
			catch(Exception e){
				Debug.print(e.getMessage());
			}
		}
	}
}
