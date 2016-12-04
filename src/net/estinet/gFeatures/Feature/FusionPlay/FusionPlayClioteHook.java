package net.estinet.gFeatures.Feature.FusionPlay;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.Friendship.Friendship;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsPending;

public class FusionPlayClioteHook extends ClioteHook{

	public FusionPlayClioteHook(gFeature feature) {
		super(feature, "fusionplay");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(args.get(0).equals("done")){
				if(Friendship.cacheNames.contains(args.get(1))){
					Friendship.cacheNames.remove(args.get(1));
					FriendsPending fl = new FriendsPending();
					fl.init(Friendship.friendreq.get(args.get(1)), args.get(1));
					Friendship.friendreq.remove(args.get(1));
				}
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
