package net.estinet.gFeatures.Feature.gWarsSuite;

import java.util.Arrays;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.Command.EstiCommand;

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

public class Configure {
	@Configs
	public static void onSetup(){
		gWarsSuite base = new gWarsSuite("gWarsSuite", "3.7.2");
		Basic.addFeature(base);
		
		EstiCommand test = new EstiCommand("gWarss", "gWarsSuite core command.", "/gWarss help", base, Arrays.asList("gw"), true);
		Basic.addCommand(test);
	}
}
