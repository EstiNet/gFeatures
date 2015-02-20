package tk.genesishub.gFeatures.Listeners.YAML;

import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;

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
	gHubPlugin ghp = new gHubPlugin();
	gFactionsPlugin gfp = new gFactionsPlugin();
	gWarsSuitePlugin gwsp = new gWarsSuitePlugin();
	gDestroyCriticalPlugin gdcp = new gDestroyCriticalPlugin();
	public void Enabler(){
		gHubPlugin.setPluginState(PluginState.DISABLE);
		gFactionsPlugin.setPluginState(PluginState.DISABLE);
		gWarsSuitePlugin.setPluginState(PluginState.DISABLE);
		gDestroyCriticalPlugin.setPluginState(PluginState.DISABLE);
	}
}
