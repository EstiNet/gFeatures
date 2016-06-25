package net.estinet.gFeatures.Feature.Friendship;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsList;

public class FriendGetClioteHook extends ClioteHook{

	public FriendGetClioteHook(gFeature feature) {
		super(feature, "friendget");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(args.get(0).equals("done")){
				if(Friendship.cacheNames.contains(args.get(1))){
					Friendship.cacheNames.remove(args.get(1));
					FriendsList fl = new FriendsList();
					fl.init(Friendship.friendget.get(args.get(1)), args.get(1));
					Friendship.friendget.remove(args.get(1));
				}
			}
			else{
				Friendship.statusRequest.put(args.get(0), args.get(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
