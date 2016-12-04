package net.estinet.gFeatures.Feature.FusionPlay;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;

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
				break;
			case "other":
				File f = new File("plugins/gFeatures/FusionPlay/notminigame.txt");
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stop");
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
