package tk.genesishub.gFeatures.PluginManage;

public class gFactionsPlugin {
	PluginState state;
	static double version;
	public gFactionsPlugin(){}
	public gFactionsPlugin(PluginState state1){
			this.state = state1;
	}
	public gFactionsPlugin(double version1){
		version = version1;
	}
	public double getVersion(){
		return version;
	}
	public PluginState getState(){
		return this.state;
	}
}
