package tk.genesishub.gFeatures.Presets;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gHubPlugin;

public class gHubPreset {
	public void Initialize(){
		GenesisAccessPlugin.setPluginState(PluginState.ENABLE);
		gHubPlugin.setPluginState(PluginState.ENABLE);
	}
}
