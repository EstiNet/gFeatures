package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.Command.EstiCommand;
import net.estinet.gFeatures.Feature.gHub.command.gHubCommand;

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

public class Configure {
	@Configs
	public static void onSetup(){
		gHub base = new gHub("gHub", "1.3.1");
		Basic.addFeature(base);
		
		EstiCommand test = new EstiCommand("gHub", "gHub core command.", "/gHub", "gFeatures.admin", base, new gHubCommand());
		Basic.addCommand(test);
		
		MGDoneClioteHook mgdch = new MGDoneClioteHook(base);
		ClioteSky.addClioteHook(mgdch);
		MGReturnClioteHook mgrch = new MGReturnClioteHook(base);
		ClioteSky.addClioteHook(mgrch);
		MGStartClioteHook mgsch = new MGStartClioteHook(base);
		ClioteSky.addClioteHook(mgsch);
	}
}
