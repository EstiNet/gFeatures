package net.estinet.gFeatures.ClioteSky.Network.Protocol.Input;

import java.util.ArrayList;
import java.util.List;

import net.estinet.gFeatures.FeatureState;
import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.ClioteSky.ClioteSky;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.ClioteSky.Network.Protocol.Packet;
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

public class InputMessage extends Packet{
	public InputMessage(){
		super.name = "Message";
	}
	public void run(List<String> args){
		List<String> newArgs = new ArrayList<>();
		for(int i = 3; i < args.size(); i++){
			newArgs.add(args.get(i));
		}
		Debug.print("Recieved message " + args + " from category " + args.get(0) + " and cliote " + args.get(1));
		for(ClioteHook ch : ClioteSky.hooks){
			if(ch.getCoreArgument().equals(args.get(2)) && gFeatures.getFeature(ch.getgFeature().getName()).getState().equals(FeatureState.ENABLE)){
				ch.run(newArgs, args.get(0), args.get(1));
			}
		}
	}
}