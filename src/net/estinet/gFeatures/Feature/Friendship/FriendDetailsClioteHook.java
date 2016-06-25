package net.estinet.gFeatures.Feature.Friendship;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.md_5.bungee.api.ChatColor;

public class FriendDetailsClioteHook extends ClioteHook{

	public FriendDetailsClioteHook(gFeature feature) {
		super(feature, "frienddetails");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(args.get(0).equals("offline")){
				String compile = ChatColor.RED + "OFFLINE: " + ChatColor.RESET + " Last seen on " + args.get(2) + "\nWas on ";
				for(int i = 3; i < args.size(); i++){
					compile += args.get(i) + " ";
				}
				Friendship.friendget.get(Friendship.statusRequest.get(args.get(1))).put(args.get(1), compile);
				Friendship.statusRequest.remove(args.get(1));
			}
			else{
				Friendship.friendget.get(Friendship.statusRequest.get(args.get(2))).put(args.get(2), ChatColor.GREEN + "ONLINE: " + ChatColor.RESET + "Currently on " + args.get(1));
				Friendship.statusRequest.remove(args.get(2));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
