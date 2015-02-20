package tk.genesishub.gFeatures.PluginManage;

public class gWarsSuitePlugin {
	public static PluginState state;
	static double version;
	public gWarsSuitePlugin(){}
	public gWarsSuitePlugin(PluginState state1){
			gWarsSuitePlugin.state = state1;
	}
	public gWarsSuitePlugin(double version1){
		version = version1;
	}
	public double getVersion(){
		return version;
	}
	public PluginState getState(){
		return gWarsSuitePlugin.state;
	}
}
