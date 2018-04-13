package net.estinet.gFeatures.ClioteSkyOld;

import net.estinet.gFeatures.ClioteSkyOld.Network.Protocol.Input.InputAlive;
import net.estinet.gFeatures.ClioteSkyOld.Network.Protocol.Input.InputError;
import net.estinet.gFeatures.ClioteSkyOld.Network.Protocol.Input.InputMessage;

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

public class ClioteInit {
	public void enable(){
		ClioteConfigUtil ccu = new ClioteConfigUtil();
		ccu.load();
		if(ClioteSky.isEnable()){
			ClioteSky.printLine("Connecting to ClioteSkyOld...");
			ClioteSky.inputPackets.add(new InputAlive());
			ClioteSky.inputPackets.add(new InputError());
			ClioteSky.inputPackets.add(new InputMessage());
			ccu.fillCacheFromFile();
			ClioteSky.setServerOnline(true);
		}
	}
}
