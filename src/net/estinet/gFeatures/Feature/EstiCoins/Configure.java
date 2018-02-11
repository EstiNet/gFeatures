package net.estinet.gFeatures.Feature.EstiCoins;

import net.estinet.gFeatures.Command.EstiCommand;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.gFeatures;

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

public class Configure {
	@Configs
	public static void onSetup(){
		EstiCoins base = new EstiCoins("EstiCoins", "1.2.0");
		gFeatures.addFeature(base);
		
		EstiCommand test = new EstiCommand("coins", "Money related commands.", "/coins help", base, true);
		gFeatures.addCommand(test);
	}
}
