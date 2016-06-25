package net.estinet.gFeatures.Feature.Friendship;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsList;

public class FriendDetailsClioteHook extends ClioteHook{

	public FriendDetailsClioteHook(gFeature feature) {
		super(feature, "frienddetails");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(args.get(0).equals("offline")){
				Friendship.statusRequest.get(args.get)
			}
			else{
				CliotePing cp = new CliotePing();
				cp.sendMessage("friends obtain " + args.get(1), "Bungee");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
