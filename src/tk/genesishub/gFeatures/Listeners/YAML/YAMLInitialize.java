package tk.genesishub.gFeatures.Listeners.YAML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;
import tk.genesishub.gFeatures.Presets.gDestroyPreset;
import tk.genesishub.gFeatures.Presets.gWarsPreset;

/*
gFeatures
https://github.com/Seshpenguin/gFeatures

   Copyright 2015 DolphinBox

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
public class YAMLInitialize {
	File f = new File("plugins/gFeatures/Config.yml");
	gWarsPreset gwp = new gWarsPreset();
	gDestroyPreset gdp = new gDestroyPreset();
	gHubPlugin ghp = new gHubPlugin();
	gFactionsPlugin gfp = new gFactionsPlugin();
	gWarsSuitePlugin gwsp = new gWarsSuitePlugin();
	gDestroyCriticalPlugin gdcp = new gDestroyCriticalPlugin();
	GenesisAccessPlugin gap = new GenesisAccessPlugin();
	public void Enabler() throws FileNotFoundException, YamlException{
		 YamlReader reader = new YamlReader(new FileReader(f));
		    Object object = reader.read();
		    Map map = (Map)object;
		    if(map.get("gWars") == "true"){
		    	gwp.Initialize();
		    }
		    if(map.get("gDestroy") == "true"){
		    	gdp.Initialize();
		    }
		gHubPlugin.setPluginState(PluginState.DISABLE);
		gFactionsPlugin.setPluginState(PluginState.DISABLE);
		gDestroyCriticalPlugin.setPluginState(PluginState.DISABLE);
	}
}
