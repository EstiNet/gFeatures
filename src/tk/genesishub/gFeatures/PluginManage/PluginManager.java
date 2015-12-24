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
		if(getPluginState(Plugins.gDestroyCritical).equals(PluginState.ENABLE)){
			plugins.add(Plugins.gDestroyCritical);
		}
		if(getPluginState(Plugins.GenesisAccess).equals(PluginState.ENABLE)){
			plugins.add(Plugins.GenesisAccess);
		}
		if(getPluginState(Plugins.gFactions).equals(PluginState.ENABLE)){
			plugins.add(Plugins.gFactions);
		}
		if(getPluginState(Plugins.gHub).equals(PluginState.ENABLE)){
			plugins.add(Plugins.gHub);
		}
		if(getPluginState(Plugins.gFeatures).equals(PluginState.ENABLE)){
			plugins.add(Plugins.gFeatures);
		}
		if(getPluginState(Plugins.gWarsSuite).equals(PluginState.ENABLE)){
			plugins.add(Plugins.gWarsSuite);
		}
		if(getPluginState(Plugins.GenesisBackup).equals(PluginState.ENABLE)){
			plugins.add(Plugins.GenesisBackup);
		}
		if(getPluginState(Plugins.GenesisEconomy).equals(PluginState.ENABLE)){
			plugins.add(Plugins.GenesisEconomy);
		}
		if(getPluginState(Plugins.gScore).equals(PluginState.ENABLE)){
			plugins.add(Plugins.gScore);
		}
		if(getPluginState(Plugins.HideAndSeek).equals(PluginState.ENABLE)){
			plugins.add(Plugins.HideAndSeek);
		}
		if(getPluginState(Plugins.gMusic).equals(PluginState.ENABLE)){
			plugins.add(Plugins.gMusic);
		}
		if(getPluginState(Plugins.CTF).equals(PluginState.ENABLE)){
			plugins.add(Plugins.CTF);
		}
		if(getPluginState(Plugins.gUtilities).equals(PluginState.ENABLE)){
			plugins.add(Plugins.gUtilities);
		}
		return plugins;
	}
	public List<Plugins> getDisabledPlugins(){
		List<Plugins> plugins = new ArrayList<>();
		if(getPluginState(Plugins.gDestroyCritical).equals(PluginState.DISABLE)){
			plugins.add(Plugins.gDestroyCritical);
		}
		if(getPluginState(Plugins.GenesisAccess).equals(PluginState.DISABLE)){
			plugins.add(Plugins.GenesisAccess);
		}
		if(getPluginState(Plugins.gFactions).equals(PluginState.DISABLE)){
			plugins.add(Plugins.gFactions);
		}
		if(getPluginState(Plugins.gHub).equals(PluginState.DISABLE)){
			plugins.add(Plugins.gHub);
		}
		if(getPluginState(Plugins.gFeatures).equals(PluginState.DISABLE)){
			plugins.add(Plugins.gFeatures);
		}
		if(getPluginState(Plugins.gWarsSuite).equals(PluginState.DISABLE)){
			plugins.add(Plugins.gWarsSuite);
		}
		if(getPluginState(Plugins.GenesisBackup).equals(PluginState.DISABLE)){
			plugins.add(Plugins.GenesisBackup);
		}
		if(getPluginState(Plugins.GenesisEconomy).equals(PluginState.DISABLE)){
			plugins.add(Plugins.GenesisEconomy);
		}
		if(getPluginState(Plugins.gScore).equals(PluginState.DISABLE)){
			plugins.add(Plugins.gScore);
		}
		if(getPluginState(Plugins.HideAndSeek).equals(PluginState.DISABLE)){
			plugins.add(Plugins.HideAndSeek);
		}
		if(getPluginState(Plugins.gMusic).equals(PluginState.DISABLE)){
			plugins.add(Plugins.gMusic);
		}
		if(getPluginState(Plugins.gUtilities).equals(PluginState.DISABLE)){
			plugins.add(Plugins.gUtilities);
		}
		if(getPluginState(Plugins.CTF).equals(PluginState.DISABLE)){
			plugins.add(Plugins.CTF);
		}
		return plugins;
	}
	public PluginState getPluginState(Plugins p){
		PluginState ps = PluginState.UNKNOWNPLUGIN;
		switch(p){
		case gWarsSuite:
			ps = gWarsSuitePlugin.getState();
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
		case gScore:
			ps = GenesisScorePlugin.getState();
			break;
		case HideAndSeek:
			ps = HideAndSeekPlugin.getState();
			break;
		case gMusic:
			ps = gMusicPlugin.getState();
		case CTF:
			ps = CTFPlugin.getState();
		case gUtilities:
			ps = gUtilitiesPlugin.getState();
		case UnknownPlugin:
			break;
		default:
			break;
		}
		return ps;
	}
}
