package net.estinet.gFeatures.Feature.ParkourRace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.Command.EstiCommand;
import net.estinet.gFeatures.Feature.Base.Commands.TestCommand;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
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
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionMap;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionSettings;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;
import net.estinet.gFeatures.SQL.Player.EstiSet;
import net.estinet.gFeatures.SQL.Player.Key;
public class Configure{
	@Configs
	public static void onSetup(){
		ParkourRace fg = new ParkourRace("ParkourRace", "1.0-ALPHA-DEV");
		FusionSettings fs = new FusionSettings();
		fs.setAutoLoadMap(true);
		fs.setDefaultMapName("world");
		fs.setUsesSpawns(true);
		fs.setTimeManager(new TimeManager(3, TimeUnit.MINUTES));
		fg.setSettings(fs);
		fg.setMaps(MapsConfigure.init());
		FusionPlay.addGame(fg);
		Basic.addFeature(fg);
	}
}
