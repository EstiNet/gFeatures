package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import org.bukkit.entity.Player;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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

public class Summon {
	AirplaneSummoner as = new AirplaneSummoner();
	BoatSummoner bs = new BoatSummoner();
	public void Initialize(Player p, String value){
		if(value.equals("airplane")){
		as.AirplaneSummon(p);
		}
		else if(value.equals("boat")){
		bs.BoatSummon(p);
		}
		}
}
