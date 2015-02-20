package tk.genesishub.gFeatures.PluginManage;

public class gHubPlugin {
	PluginState state;
	static double version;
	public gHubPlugin(){}
	public gHubPlugin(PluginState state1){
			this.state = state1;
	}
	public gHubPlugin(double version1){
		version = version1;
	}
	public double getVersion(){
		return version;
	}
	public PluginState getState(){
		return this.state;
	}
}
