package net.estinet.gFeatures.Feature.Friendship;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsList;

public class FriendReqClioteHook extends ClioteHook{

	public FriendReqClioteHook(gFeature feature) {
		super(feature, "friendreq");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(args.get(0).equals("done")){
				Friendship.cacheNames.remove(args.get(1));
				FriendsList fl = new FriendsList();
				fl.init(Friendship.friendget.get(args.get(1)), args.get(1));
				Friendship.friendget.remove(args.get(1));
			}
			else{
				Friendship.statusRequest.put(args.get(1), args.get(2));
				CliotePing cp = new CliotePing();
				cp.sendMessage("friends obtain " + args.get(1), "Bungee");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
