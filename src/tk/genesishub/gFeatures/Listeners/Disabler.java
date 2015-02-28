package tk.genesishub.gFeatures.Listeners;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisBackupPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisEconomyPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;
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

public class Disabler {
	SkriptManager sm = new SkriptManager();
	public void Initialize(){
		if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.gWarsSuite.Listeners Listener = new tk.genesishub.gFeatures.gWarsSuite.Listeners();
			Listener.onDisable();
			gWarsSuitePlugin.setPluginState(PluginState.DISABLE);
		}
		if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.gDestroyCritical.Listeners Listener = new tk.genesishub.gFeatures.gDestroyCritical.Listeners();
			Listener.onDisable();
			gDestroyCriticalPlugin.setPluginState(PluginState.DISABLE);
		}
		if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.GenesisAccess.Main Listener = new tk.genesishub.gFeatures.GenesisAccess.Main();
			Listener.onDisable();
			GenesisAccessPlugin.setPluginState(PluginState.DISABLE);
		}
		if(gFactionsPlugin.getState().equals(PluginState.ENABLE)){
			gFactionsPlugin.setPluginState(PluginState.DISABLE);
		}
		if(gHubPlugin.getState().equals(PluginState.ENABLE)){
			gHubPlugin.setPluginState(PluginState.DISABLE);
		}
		if(GenesisBackupPlugin.getState().equals(PluginState.ENABLE)){
			GenesisBackupPlugin.setPluginState(PluginState.DISABLE);
		}
		if(GenesisEconomyPlugin.getState().equals(PluginState.ENABLE)){
			GenesisEconomyPlugin.setPluginState(PluginState.DISABLE);
		}
		sm.Disable(Skripts.gEssentialsHub);
		sm.Disable(Skripts.gEssentialsMinigames);
		sm.Disable(Skripts.gEssentialsFactions);
		sm.Disable(Skripts.gEssentialsGlobal);
		sm.Disable(Skripts.gMMO);
		sm.Disable(Skripts.gCrates);
	}
}
