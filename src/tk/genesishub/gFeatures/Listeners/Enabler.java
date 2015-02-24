package tk.genesishub.gFeatures.Listeners;

import java.io.IOException;

import tk.genesishub.gFeatures.Listeners.YAML.YAMLInitialize;
import tk.genesishub.gFeatures.Listeners.YAML.gFeaturesFileManager;
import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisBackupPlugin;
import tk.genesishub.gFeatures.PluginManage.GenesisEconomyPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gFeaturePlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;

public class Enabler {
	public void Enable() throws IOException{
		gDestroyCriticalPlugin.setPluginState(PluginState.DISABLE);
		gHubPlugin.setPluginState(PluginState.DISABLE);
		gFactionsPlugin.setPluginState(PluginState.DISABLE);
		gWarsSuitePlugin.setPluginState(PluginState.DISABLE);
		GenesisAccessPlugin.setPluginState(PluginState.DISABLE);
		gFeaturePlugin.setPluginState(PluginState.DISABLE);
		GenesisEconomyPlugin.setPluginState(PluginState.DISABLE);
		GenesisBackupPlugin.setPluginState(PluginState.DISABLE);
		YAMLInitialize ymli = new YAMLInitialize();
		gFeaturesFileManager gffm = new gFeaturesFileManager();
		gffm.exists();
		ymli.Enabler();
		gffm.exists();
		if(gDestroyCriticalPlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.gDestroyCritical.Listeners Listeners = new tk.genesishub.gFeatures.gDestroyCritical.Listeners();
			Listeners.onEnable();
		}
		if(gHubPlugin.getState().equals(PluginState.ENABLE)){
			
		}
		if(gFactionsPlugin.getState().equals(PluginState.ENABLE)){
			
		}
		if(gWarsSuitePlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.gWarsSuite.Listeners Listeners = new tk.genesishub.gFeatures.gWarsSuite.Listeners();
			Listeners.onEnable();
		}
		if(GenesisAccessPlugin.getState().equals(PluginState.ENABLE)){
			tk.genesishub.gFeatures.GenesisAccess.Main Listeners = new tk.genesishub.gFeatures.GenesisAccess.Main();
			Listeners.onEnable();
		}
	}
}
