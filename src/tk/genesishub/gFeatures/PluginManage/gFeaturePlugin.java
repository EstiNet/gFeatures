package tk.genesishub.gFeatures.PluginManage;

public class gFeaturePlugin {
	PluginState state;
	static double version;
	public gFeaturePlugin(PluginState state1){
			this.state = state1;
	}
	public gFeaturePlugin(double version1){
		version = version1;
	}
	public double getVersion(){
		return version;
	}
	public PluginState getState(){
		return this.state;
	}
}
