package net.estinet.gFeatures.Feature.Bedwars;

import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.gFeature;

import java.util.List;

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

public class GetMGInfoClioteHook extends ClioteHook{

	public GetMGInfoClioteHook(gFeature feature) {
		super(feature, "getmginfo");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(Basic.mode.equals(Mode.WAITING)){
				CliotePing cp = new CliotePing();
				cp.sendMessage("mghello", "Bungee");
			}
			else{
				CliotePing cp = new CliotePing();
				cp.sendMessage("mgstart", "Bungee");
			}
			CliotePing cp = new CliotePing();
			cp.sendMessage("mgmap " + Basic.mapName, "Bungee");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
