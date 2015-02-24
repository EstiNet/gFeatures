package tk.genesishub.gFeatures.PluginManage;

import java.util.ArrayList;
import java.util.List;

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

public class PluginManager {
	public List<Plugins> getEnabledPlugins(){
		List<Plugins> plugins = new ArrayList<>();
		if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
			plugins.add(Plugins.gDestroyCritical);
		}
		if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
			plugins.add(Plugins.GenesisAccess);
		}
		if(gFactionsPlugin.getState().equals(PluginState.ENABLE)){
			plugins.add(Plugins.gFactions);
		}
		if(gHubPlugin.getState().equals(PluginState.ENABLE)){
			plugins.add(Plugins.gHub);
		}
		if(gFeaturePlugin.getState().equals(PluginState.ENABLE)){
			plugins.add(Plugins.gFeatures);
		}
		if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			plugins.add(Plugins.gWarsSuite);
		}
		if(GenesisBackupPlugin.getState().equals(PluginState.ENABLE)){
			plugins.add(Plugins.GenesisBackup);
		}
		if(GenesisEconomyPlugin.getState().equals(PluginState.ENABLE)){
			plugins.add(Plugins.GenesisEconomy);
		}
		return plugins;
	}
	public List<Plugins> getDisabledPlugins(){
		List<Plugins> plugins = new ArrayList<>();
		if(gDestroyCriticalPlugin.getState().equals(PluginState.DISABLE)){
			plugins.add(Plugins.gDestroyCritical);
		}
		if(GenesisAccessPlugin.getState().equals(PluginState.DISABLE)){
			plugins.add(Plugins.GenesisAccess);
		}
		if(gFactionsPlugin.getState().equals(PluginState.DISABLE)){
			plugins.add(Plugins.gFactions);
		}
		if(gHubPlugin.getState().equals(PluginState.DISABLE)){
			plugins.add(Plugins.gHub);
		}
		if(gFeaturePlugin.getState().equals(PluginState.DISABLE)){
			plugins.add(Plugins.gFeatures);
		}
		if(gWarsSuitePlugin.getState().equals(PluginState.DISABLE)){
			plugins.add(Plugins.gWarsSuite);
		}
		if(GenesisBackupPlugin.getState().equals(PluginState.DISABLE)){
			plugins.add(Plugins.GenesisBackup);
		}
		if(GenesisEconomyPlugin.getState().equals(PluginState.DISABLE)){
			plugins.add(Plugins.GenesisEconomy);
		}
		return plugins;
	}
	public PluginState getPluginState(Plugins p){
		PluginState ps = PluginState.UNKNOWNPLUGIN;
		switch(p){
		case gWarsSuite:
			break;
		case gFactions:
			ps = gFactionsPlugin.getState();
			break;
		case gFeatures:
			ps = PluginState.ENABLE;
			break;
		case gDestroyCritical:
			ps = gDestroyCriticalPlugin.getState();
			break;
		case gHub:
			ps = gHubPlugin.getState();
			break;
		case GenesisAccess:
			ps = GenesisAccessPlugin.getState();
			break;
		case GenesisEconomy:
			ps = GenesisEconomyPlugin.getState();
			break;
		case GenesisBackup:
			ps = GenesisBackupPlugin.getState();
			break;
		}
		return ps;
	}
}
