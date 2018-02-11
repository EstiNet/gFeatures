package net.estinet.gFeatures.Feature.Spleef;

import java.util.concurrent.TimeUnit;

import net.estinet.gFeatures.Configs;
import net.estinet.gFeatures.Feature.FusionPlay.FusionPlay;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.FusionSettings;
import net.estinet.gFeatures.Feature.FusionPlay.GameUtil.TimeManager;
import net.md_5.bungee.api.ChatColor;

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

public class Configure{
	public static Spleef fg;
	@Configs
	public static void onSetup(){
		fg = new Spleef("Spleef", "1.0.0");
		FusionSettings fs = new FusionSettings();
		fs.setAutoLoadMap(true);
		fs.setDefaultMapName("world");
		fs.setUsesSpawns(true);
		fs.setDependsOnTimer(true);
		fs.setTimeManager(new TimeManager(5, TimeUnit.MINUTES));
		fs.setDefaultWaitingSecLeft(10);
		fs.setWaitingSecLeft(10);
		fs.setCoolGameName(ChatColor.BOLD + "ヾ(⌐■_■)ノ♪" + ChatColor.DARK_BLUE + " Spleef");
		fg.setSettings(fs);
		fg.setMaps(MapsConfigure.init());
		FusionPlay.addGame(fg);
	}
}
