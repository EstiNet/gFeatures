package net.estinet.gFeatures.Feature.CTF;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;

public class GetMGInfoClioteHook extends ClioteHook{

	public GetMGInfoClioteHook(gFeature feature) {
		super(feature, "getmginfo");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(Basic.mode.equals(Mode.WAITING)){
				CliotePing cp = new CliotePing();
				cp.sendMessage("mghello", "Bungee");
			}
			else{
				CliotePing cp = new CliotePing();
				cp.sendMessage("mgstart", "Bungee");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
