package tk.genesishub.gFeatures.Presets;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gDestroyCriticalPlugin;

public class gDestroyPreset {
	public void Initialize(){
		gDestroyCriticalPlugin.setPluginState(PluginState.ENABLE);
		GenesisAccessPlugin.setPluginState(PluginState.ENABLE);
	}
}
