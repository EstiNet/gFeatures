package net.estinet.gFeatures.Feature.gHub;

import java.util.List;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSky.API.ClioteHook;
import net.estinet.gFeatures.Feature.gHub.crystal.MGServerPlus;

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

public class MGReturnClioteHook extends ClioteHook{

	public MGReturnClioteHook(gFeature feature) {
		super(feature, "mgrecieve");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			if(Basis.recieving == true){
				MGServerPlus mgsp = new MGServerPlus(args.get(0), args.get(1), args.get(2), args.get(3));
				Basis.assemble.add(mgsp);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
