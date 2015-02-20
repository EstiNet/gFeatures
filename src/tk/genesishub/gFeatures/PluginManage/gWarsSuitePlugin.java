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
	static public void setPluginState(PluginState pluginstate){
		state = pluginstate;
	}
	static public void setVersion(double pluginversion){
		version = pluginversion;
	}
	static public double getVersion(){
		return version;
	}
	static public PluginState getState(){
		return gWarsSuitePlugin.state;
	}
}
