package net.estinet.gFeatures.Feature.FusionPlay;

import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse.OtherResponse;
import net.estinet.gFeatures.Feature.FusionPlay.ClioteResponse.StartResponse;

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

public class FusionPlayClioteHook extends ClioteHook{

	public FusionPlayClioteHook(gFeature feature){
		super(feature, "fusionplay");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			CliotePing cp = new CliotePing();
			switch(args.get(0)){
			case "start":
				StartResponse.response(args, categoryName, clioteName);
				break;
			case "other":
				OtherResponse.response(args, categoryName, clioteName);
				break;
			case "obtain":
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stop");
				break;
			case "alive":
				cp.sendMessage("fusionplay alive", "Bungee");
				break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
