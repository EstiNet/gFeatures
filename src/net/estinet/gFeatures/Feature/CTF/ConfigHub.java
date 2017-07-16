package net.estinet.gFeatures.Feature.CTF;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import net.estinet.gFeatures.Configuration.Config;
import net.estinet.gFeatures.Feature.CTF.Confligs.ConfligInit;
import net.estinet.gFeatures.Feature.CTF.MapsSpec.Spec;

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

public class ConfigHub {
	Config config = new Config();
	Spec spec = new Spec();
	ConfligInit ci = new ConfligInit();
	File f = new File("plugins/gFeatures/CTF/Config.yml");
	File ctf1 = new File("plugins/gFeatures/CTF/CTF1");
	File ctf2 = new File("plugins/gFeatures/CTF/CTF2");
	public void setupConfig(){
		List<Maps> maps = new ArrayList<>();
		config.createDirectory("plugins/gFeatures/CTF", "[CTF] plugin directory set!");
		if(ctf1.isDirectory()){
			maps.add(Maps.One);
		}
		if(ctf2.isDirectory()){
			maps.add(Maps.Two);
		}
		if(maps.isEmpty()){
			Bukkit.getLogger().info("[CTF] No maps found!");
			Disable.onDisable();
			net.estinet.gFeatures.gFeatures.getFeature("CTF").disable();
			return;
		}
		int random = (int) Math.floor(Math.random() * maps.size());
		spec.direction(maps.get(random));
		
		ci.createConfigs();
	}
}
