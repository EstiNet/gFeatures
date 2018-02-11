package net.estinet.gFeatures.Feature.Friendship;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.md_5.bungee.api.ChatColor;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class FriendDetailsClioteHook extends ClioteHook{

	public FriendDetailsClioteHook(gFeature feature) {
		super(feature, "frienddetails");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(args.get(0).equals("offline")){
				String compile = ChatColor.RED + "OFFLINE: " + ChatColor.RESET + " Last seen on " + ChatColor.DARK_AQUA + args.get(2) + "\n" + ChatColor.DARK_AQUA + "Last seen: " + ChatColor.WHITE;
				for(int i = 3; i < args.size(); i++){
					compile += args.get(i) + " ";
				}
				Friendship.friendget.get(Friendship.statusRequest.get(args.get(1))).put(args.get(1), compile);
				Friendship.statusRequest.remove(args.get(1));
			}
			else{
				Friendship.friendget.get(Friendship.statusRequest.get(args.get(2))).put(args.get(2), ChatColor.GREEN + "ONLINE " + ChatColor.RESET + "\n" + ChatColor.WHITE + "Currently on " + ChatColor.DARK_AQUA + args.get(1));
				Friendship.statusRequest.remove(args.get(2));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
 