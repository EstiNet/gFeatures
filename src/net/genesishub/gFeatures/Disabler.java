package net.genesishub.gFeatures;

import java.util.List;

import net.genesishub.gFeatures.API.PlayerStats.gPlayer;
import net.genesishub.gFeatures.Plus.Skript.SkriptManager;

/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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

public class Disabler {
	public void onDisable(){
		List<gFeature> features = Basic.getFeatures();
		List<Extension> extensions = Basic.getExtensions();
		for(gFeature feature : features){
			if(feature.getState().equals(FeatureState.ENABLE)){
				try{
					feature.disable();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		for(Extension extension : extensions){
			if(extension.getState().equals(FeatureState.ENABLE) && extension.getType().equals(ExtensionsType.Skript)){
				SkriptManager sm = new SkriptManager();
				sm.Disable(extension);
			}
		}
		for(gPlayer gp : Basic.getgPlayers()){
			net.genesishub.gFeatures.API.PlayerStats.Setup setup = new net.genesishub.gFeatures.API.PlayerStats.Setup();
			setup.flushPlayer(gp);
		}
		Basic.resetFeatures();
		Basic.resetExtensions();
	}
}
