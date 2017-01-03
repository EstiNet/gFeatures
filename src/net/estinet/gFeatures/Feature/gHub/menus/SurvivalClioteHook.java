package net.estinet.gFeatures.Feature.gHub.menus;

import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;

public class SurvivalClioteHook extends ClioteHook{

	public SurvivalClioteHook(gFeature feature) {
		super(feature, "survival");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			SurvivalMenu sm = new SurvivalMenu();
			sm.init(Bukkit.getPlayer(args.get(0)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
