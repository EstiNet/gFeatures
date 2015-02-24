package tk.genesishub.gFeatures.PluginManage;

import java.util.ArrayList;
import java.util.List;

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
