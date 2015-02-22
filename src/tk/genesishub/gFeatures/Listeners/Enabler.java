package tk.genesishub.gFeatures.Listeners;

import java.io.IOException;

import tk.genesishub.gFeatures.Listeners.YAML.YAMLInitialize;
import tk.genesishub.gFeatures.Listeners.YAML.gFeaturesFileManager;
import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;

public class Enabler {
	public void Enable() throws IOException{
		gDestroyCriticalPlugin.setPluginState(PluginState.DISABLE);
		gHubPlugin.setPluginState(PluginState.DISABLE);
		gFactionsPlugin.setPluginState(PluginState.DISABLE);
		gWarsSuitePlugin.setPluginState(PluginState.DISABLE);
		GenesisAccessPlugin.setPluginState(PluginState.DISABLE);
		YAMLInitialize ymli = new YAMLInitialize();
		gFeaturesFileManager gffm = new gFeaturesFileManager();
		gffm.exists();
		ymli.Enabler();
		gffm.exists();
	}
}
