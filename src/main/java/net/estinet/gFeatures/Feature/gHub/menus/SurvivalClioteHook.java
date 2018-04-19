package net.estinet.gFeatures.Feature.gHub.menus;

import java.util.List;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.gFeature;
import net.estinet.gFeatures.ClioteSkyOld.API.ClioteHook;

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

public class SurvivalClioteHook extends ClioteHook{

	public SurvivalClioteHook(gFeature feature) {
		super(feature, "survival");
	}
	@Override
	public void run(List<String> args, String categoryName, String clioteName){
		try{
			try{
			SurvivalMenu sm = new SurvivalMenu();
			sm.init(Bukkit.getPlayer(args.get(0)));
			}
			catch(NullPointerException e){}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
