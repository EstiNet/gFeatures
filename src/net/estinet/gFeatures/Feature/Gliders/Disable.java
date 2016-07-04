package net.estinet.gFeatures.Feature.Gliders;

import org.bukkit.Bukkit;

import net.estinet.gFeatures.ClioteSky.API.CliotePing;
import net.estinet.gFeatures.Feature.Gliders.Confligs.ConfligInit;

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

public class Disable{
	public static void onDisable(){
		Bukkit.getLogger().info("[Gliders] Disabled :/");
		ConfligInit ci = new ConfligInit();
		ci.deleteConfigs();
		CliotePing cp = new CliotePing();
		cp.sendMessage("mgcomplete", "Bungee");
	}
}
