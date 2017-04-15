package net.estinet.gFeatures.Feature.ServerQuery;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.estinet.gFeatures.FeatureState;
import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.gScore.Listeners;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2017 EstiNet

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

public class ServerQueryClioteHook extends ClioteHook{

	public ServerQueryClioteHook(gFeature feature) {
		super(feature, "info");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		if(args.get(0).equals("online")){
			ServerQuery.setPlayerCount(Integer.parseInt(args.get(1)));
			if(Basic.getFeature("gScore").getState().equals(FeatureState.ENABLE)){
				Listeners l = new Listeners();
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
		        	public void run(){
							try {
								for(Player p : Bukkit.getOnlinePlayers()){
									l.set(p);
								}
						} catch (IllegalArgumentException e) {
						} catch (IllegalStateException e) {
						}
		        	}
		        }, 40L);
			}
		}
		else if(args.get(0).equals("playerget")){
			Execute e = ServerQuery.hash.get(args.get(1));
			e.server = args.get(2);
			e.run();
		}
	}
}
