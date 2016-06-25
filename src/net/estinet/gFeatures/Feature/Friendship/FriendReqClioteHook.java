package net.estinet.gFeatures.Feature.Friendship;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsPending;

public class FriendReqClioteHook extends ClioteHook{

	public FriendReqClioteHook(gFeature feature) {
		super(feature, "friendreq");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(args.get(0).equals("done")){
				Friendship.cacheNames.remove(args.get(1));
				FriendsPending fl = new FriendsPending();
				fl.init(Friendship.friendreq.get(args.get(1)), args.get(1));
				Friendship.friendreq.remove(args.get(1));
			}
			else{
				Friendship.friendreq.get(args.get(1)).add(args.get(0));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
