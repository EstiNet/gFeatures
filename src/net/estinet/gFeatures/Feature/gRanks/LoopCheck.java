package net.estinet.gFeatures.Feature.gRanks;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.gRanks.Perms.Cleanup;

import org.bukkit.Bukkit;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class LoopCheck {
	public void start(){
		Retrieve r = new Retrieve();
		if(!r.getClioteSkySupport()){
			Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
				public void run(){
					Thread th = new Thread(new Runnable(){
						public void run(){
							try{
								Basis b = new Basis();
								b.initializeQuery();
							}
							catch(Exception e){
								Debug.print(e.getMessage());
							}
						}
					});
					th.start();
				}
			}, 1000L, 1000L);
			Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
				public void run(){
					try{
						Thread th = new Thread(new Cleanup());
						th.start();
					}
					catch(Exception e){
						Debug.print(e.getMessage());
					}
				}
			}, 9000L, 9000L);
		}
	}
}
