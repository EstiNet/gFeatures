package tk.genesishub.gFeatures.PluginManage;

public class gFeaturePlugin {
	PluginState state;
	public gFeaturePlugin(PluginState state1){
			this.state = state1;
	}
	public PluginState getState(){
		return this.state;
	}
}
