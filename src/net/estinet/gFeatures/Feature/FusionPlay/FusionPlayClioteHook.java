package net.estinet.gFeatures.Feature.FusionPlay;

import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse.OtherResponse;
import net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse.StartResponse;

public class FusionPlayClioteHook extends ClioteHook{

	public FusionPlayClioteHook(gFeature feature) {
		super(feature, "fusionplay");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			CliotePing cp = new CliotePing();
			switch(args.get(0)){
			case "start":
				StartResponse.response(args, categoryName, clioteName);
				break;
			case "other":
				OtherResponse.response(args, categoryName, clioteName);
				break;
			case "obtain":
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stop");
				break;
			case "alive":
				break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
