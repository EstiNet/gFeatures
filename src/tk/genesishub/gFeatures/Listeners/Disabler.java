package tk.genesishub.gFeatures.Listeners;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;

public class Disabler {
	public void Initialize(){
		if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.gWarsSuite.Listeners Listener = new tk.genesishub.gFeatures.gWarsSuite.Listeners();
			Listener.onDisable();
		}
		if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.gDestroyCritical.Listeners Listener = new tk.genesishub.gFeatures.gDestroyCritical.Listeners();
			Listener.onDisable();
		}
		if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.GenesisAccess.Main Listener = new tk.genesishub.gFeatures.GenesisAccess.Main();
			Listener.onDisable();
		}
		if(gFactionsPlugin.getState().equals(PluginState.ENABLE)){
			
		}
		if(gHubPlugin.getState().equals(PluginState.ENABLE)){
			
		}
	}
}
