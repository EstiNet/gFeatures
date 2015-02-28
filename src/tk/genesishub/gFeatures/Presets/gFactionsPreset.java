package tk.genesishub.gFeatures.Presets;

import java.io.IOException;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.Skript.Skripts;
import tk.genesishub.gFeatures.Skript.Java.SkriptManager;

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

public class gFactionsPreset {
	public void Initialize() throws IOException{
		GenesisAccessPlugin.setPluginState(PluginState.ENABLE);
		gFactionsPlugin.setPluginState(PluginState.ENABLE);
		SkriptManager sm = new SkriptManager();
		sm.Enable(Skripts.gMMO);
		sm.Enable(Skripts.gEssentialsFactions);
	}
}
