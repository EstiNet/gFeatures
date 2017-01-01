package net.estinet.gFeatures.Feature.FusionPlay.GameUtil;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;

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

public class EnabledHandler {
	public static void init(){
		CliotePing cp = new CliotePing();
		FusionPlay.currentGame.setFusionState(FusionState.WAITING);
		if(FusionPlay.otherup){
			cp.sendMessage("fusionplay otherup " + FusionPlay.currentGame.getName(), "Bungee");
		}
		else{
			cp.sendMessage("fusionplay online " + FusionPlay.currentGame.getName(), "Bungee");
		}
	}
}
