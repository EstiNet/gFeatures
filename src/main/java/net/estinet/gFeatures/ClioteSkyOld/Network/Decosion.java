package net.estinet.gFeatures.ClioteSkyOld.Network;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.ClioteSkyOld.ClioteSky;
import net.estinet.gFeatures.ClioteSkyOld.Network.Protocol.Packet;

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

public class Decosion {
	public void decode(String message){
		String[] args = message.split("\\s+");
		for(Packet packet : ClioteSky.inputPackets){
			if(args[0].equalsIgnoreCase(packet.name)){
				List<String> newArgs = new ArrayList<>();
				for(int i = 1; i<args.length; i++){
					newArgs.add(args[i]);
				}
				packet.run(newArgs);
			}
		}
	}
}
