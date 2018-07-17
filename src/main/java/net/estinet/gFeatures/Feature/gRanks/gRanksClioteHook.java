package net.estinet.gFeatures.Feature.gRanks;

import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteHook;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import org.bukkit.Bukkit;

import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.Feature.gRanks.Perms.Cleanup;

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

public class gRanksClioteHook extends ClioteHook {

	public gRanksClioteHook(String identifier, String gFeatureName) {
		this.identifier = identifier;
		this.gFeatureName = gFeatureName;
	}

	@Override
	public void run(byte[] data, String sender) {

		List<String> args = ClioteSky.parseBytesToStringList(data);

		if(args.get(0).equals("sync")){
			try{
				Bukkit.getLogger().info("[gRanks] Syncing permissions database...");
				Thread th = new Thread(new Cleanup());
				th.start();
				Basis b = new Basis();
				b.initializeQuery();
			}
			catch(Exception e){
				Debug.print(e.getMessage());
			}
		}
	}
}