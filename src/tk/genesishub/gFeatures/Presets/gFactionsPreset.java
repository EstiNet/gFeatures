package tk.genesishub.gFeatures.Presets;

import tk.genesishub.gFeatures.PluginManage.GenesisAccessPlugin;
import tk.genesishub.gFeatures.PluginManage.PluginState;
import tk.genesishub.gFeatures.PluginManage.gFactionsPlugin;

public class gFactionsPreset {
	public void Initialize(){
		GenesisAccessPlugin.setPluginState(PluginState.ENABLE);
		gFactionsPlugin.setPluginState(PluginState.ENABLE);
	}
}
