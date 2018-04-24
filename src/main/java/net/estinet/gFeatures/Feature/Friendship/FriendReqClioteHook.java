package net.estinet.gFeatures.Feature.Friendship;

import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteHook;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.Feature.Friendship.Menus.FriendsPending;

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

public class FriendReqClioteHook extends ClioteHook {

	public FriendReqClioteHook(String identifier, String gFeatureName) {
		this.identifier = identifier;
		this.gFeatureName = gFeatureName;
	}

	@Override
	public void run(byte[] data, String sender) {

		List<String> args = ClioteSky.parseBytesToStringList(data);

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
