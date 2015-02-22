package tk.genesishub.gFeatures.Presets;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gWarsSuitePlugin;

public class gWarsPreset {
	public void Initialize(){
		gWarsSuitePlugin.setPluginState(PluginState.ENABLE);
		GenesisAccessPlugin.setPluginState(PluginState.ENABLE);
	}
}
