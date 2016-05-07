package net.estinet.gFeatures.Feature.EstiChat;

import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;

public class ConsoleClioteHook extends ClioteHook{

	public ConsoleClioteHook(gFeature feature) {
		super(feature, "consolechat");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		String mgs = "";
		String server = args.get(0);
		args.remove(0);
		for(String arg : args){
			mgs += arg + " ";
		}
		mgs = mgs.substring(0, mgs.length()-1);
		if(!mgs.equals(EstiChat.lastSent)){
			Bukkit.getLogger().info("[" + server + "] " + mgs);
		}
	}
}
