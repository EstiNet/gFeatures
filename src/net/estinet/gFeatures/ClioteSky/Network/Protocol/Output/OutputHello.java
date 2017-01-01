package net.estinet.gFeatures.ClioteSky.Network.Protocol.Output;

import java.util.List;

import net.estinet.gFeatures.ClioteSky.ClioteConfigUtil;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.Network.NetworkThread;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;

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

public class OutputHello extends Packet{
	public void run(List<String> args){
		NetworkThread nt = new NetworkThread();
		nt.sendOutput("hello " + ClioteSky.getName() + " " + ClioteSky.getPassword());
		ClioteSky.printLine("Attempting to login...");
		for(String message : ClioteSky.cachedQueries){
			if(!message.equalsIgnoreCase("alive") && !message.equalsIgnoreCase("")){
				nt.sendOutput(message);
				ClioteSky.printLine("Sending cached command " + message);
			}
		}
		ClioteConfigUtil ccu = new ClioteConfigUtil();
		ccu.resetCache();
	}
}
